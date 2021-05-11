//package net.codejava.Controller;
//
//import net.codejava.Model.Product;
//import net.codejava.Model.User;
//import net.codejava.Service.ProductService;
//import net.codejava.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/fbhome")
//    public ModelAndView viewHomePage(Model model) {
//        ModelAndView modelAndView = new ModelAndView("fbindex");
//        List<User> listUsers = userService.listAll();
//        modelAndView.addObject("listUsers",listUsers);
////		model.addAttribute("listProducts", listProducts);
////		return "index";
//        return modelAndView;
//    }
//
//
//}
