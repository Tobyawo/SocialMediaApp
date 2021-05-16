package net.Awoyomiweek7.Controller;

import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Model.Post;
import net.Awoyomiweek7.Model.PostLike;
import net.Awoyomiweek7.Model.User;
import net.Awoyomiweek7.Service.CommentService;
import net.Awoyomiweek7.Service.PostService;
import net.Awoyomiweek7.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Controller
public class PostController {

    @Autowired
    private PostService postservice;
    private CommentService commentservice;


    @RequestMapping("/facebookHome")
    public ModelAndView viewHomePage(Model model, HttpSession httpSession) {
        ModelAndView mav = new ModelAndView("fbindex");
        User user = (User) httpSession.getAttribute("user");
        mav.addObject("user",user);
        // post object to accept post attribute is available on the facebook home page
        Post post = new Post();
        mav.addObject("post",post);
        // list of posts objects  to display list of all post is also available on the facebook home page
        List<Post> listPosts = postservice.listAll();
        mav.addObject("listPosts",listPosts);

        Comment comment = new Comment();
        mav.addObject("comment",comment);
        PostLike postLike = new PostLike();
        mav.addObject("postLikes",postLike);

        return mav;
    }

    @RequestMapping(value = "/savePost", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("post") Post post, HttpSession session) {
        User authenticatedUser = (User) session.getAttribute("user");
        //just inserted this to confirm the person posting is login and in session
        if(authenticatedUser == null){return "redirect:/";}


//        model.addAttribute("post",post);
        postservice.save(post, authenticatedUser);
        return "redirect:/facebookHome";
    }

    @RequestMapping("/editPost/{postId}")
    public ModelAndView showEditPostPage(@PathVariable(name = "postId") long postId) {
        ModelAndView mav = new ModelAndView("Post_edit2");
        Post post = postservice.get(postId);
        mav.addObject("post", post);
        List<Post> listPosts = postservice.listAll();
        mav.addObject("listPosts",listPosts);
        return mav;
    }

    @RequestMapping("/deletePost/{postId}")
    public String deleteProduct(@PathVariable(name = "postId") long postId) {
        postservice.delete(postId);
        return "redirect:/facebookHome";
    }


}
