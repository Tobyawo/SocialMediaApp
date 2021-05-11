package net.codejava.Controller;

import java.util.List;

import net.codejava.Model.Product;
import net.codejava.Model.User2;
import net.codejava.Service.ProductService;
import net.codejava.Service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
 public class User2Controller{

	@Autowired
	private User2Service service;

	@RequestMapping("/b")
	public String viewHomePage2(Model model) {
		ModelAndView modelAndView = new ModelAndView("index2");
		List<User2> listUsers = service.listAll();
		modelAndView.addObject("listUsers",listUsers);
		model.addAttribute("listUsers", listUsers);
		return "index2";

	}

	@RequestMapping("/new2")
	public String showNewProductPage(Model model) {
		User2 user = new User2();
		model.addAttribute("user", user);
		return "new_User2";
	}

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User2 user, Model model) {
		service.save(user);
		return "redirect:/b";
	}

	@RequestMapping("/edit2/{userid}")
	public ModelAndView showEditProductPage(@PathVariable(name = "userid") long userid) {
		ModelAndView mav = new ModelAndView("edit_user");
		User2 user = service.get(userid);
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping("/delete2/{userid}")
	public String deleteProduct(@PathVariable(name = "userid") long userid) {
		service.delete(userid);
		return "redirect:/b";
	}

}
