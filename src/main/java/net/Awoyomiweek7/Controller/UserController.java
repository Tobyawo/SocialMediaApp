package net.Awoyomiweek7.Controller;

import java.util.Arrays;
import java.util.List;


import net.Awoyomiweek7.Model.User;
import net.Awoyomiweek7.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
 public class UserController {

	@Autowired
	private UserService service;

	//1
	@GetMapping("/")  // when a request link to loginup page is clicked on. it come here
	public String showloginForm(Model model) {
		User user = new User(); // A User object to represent the information in the form.
		model.addAttribute("user", user);
		model.addAttribute("invalid", null);
		return "loginPage";
	}


//2
	@RequestMapping(value = "/loginPost", method= RequestMethod.POST) // this is the post method that handle submitted form to the login up form
	public String checkUserlogin(@ModelAttribute("user") User user, Model model, HttpSession httpSession) {
		User user1 = service.getUserByEmail(user.getEmail());
		if (user1 == null) {
			model.addAttribute("invalid", "User does not exist. check login details or register.");
			return "loginPage";
		}
		user1 = service.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		if (user1 == null) {
			model.addAttribute("invalid", "Incorrect password");
			return "loginPage";
		}
		httpSession.setAttribute("user", user1);
		return "redirect:/Home";
	}



	@GetMapping("/Home")
	public String goHomePage(Model model, HttpSession httpSession){
		User user = (User) httpSession.getAttribute("user");
	//	model.addAttribute("newPost", new Post());
		model.addAttribute("user", user);
//		model.addAttribute("allPosts", postService.findAllOrderByPostIDDesc());
		return "fbindex";

	}



	@GetMapping("/signUp")  // when a request link to signup page is clicked on. it come here
	public String showSignUpForm(Model model) {
		User user = new User(); // A User object to represent the information in the form.
		model.addAttribute("user", user);

		List<String> listGender = Arrays.asList("Male", "Female"); //a List of Gender that will be used to display a select box/dropdown list in the form.
		model.addAttribute("listGender", listGender);

		return "SignUpPage";
	}

	@PostMapping("/handleSignUp") // this is the post method that handle submitted form from the sign up form
	public String submitSignUpForm(@ModelAttribute("user") User user) {
		service.save(user);

		ModelAndView modelAndView = new ModelAndView("loginPage");
		modelAndView.addObject("user",user);
		return "loginPage";
	}



	@RequestMapping("/b")
	public String viewHomePage2(Model model) {
		ModelAndView modelAndView = new ModelAndView("loginPage");
		List<User> listUsers = service.listAll();
		modelAndView.addObject("listUsers",listUsers);
		model.addAttribute("listUsers", listUsers);
		return "loginPage";

	}

	@RequestMapping("/new2")
	public String showNewProductPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_User2";
	}

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User user, Model model) {
		service.save(user);
		return "redirect:/b";
	}

	@RequestMapping("/edit2/{userid}")
	public ModelAndView showEditProductPage(@PathVariable(name = "userid") long userid) {
		ModelAndView mav = new ModelAndView("signUpPage");
		User user = service.get(userid);
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping("/delete2/{userid}")
	public String deleteProduct(@PathVariable(name = "userid") long userid) {
		service.delete(userid);
		return "redirect:/b";
	}

}
