package net.Awoyomiweek7.Controller;

import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Model.Post;
import net.Awoyomiweek7.Model.User;

import net.Awoyomiweek7.Service.CommentService;
import net.Awoyomiweek7.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentservice;
    @Autowired
    PostService postService;




    @PostMapping("/saveComment/{postId}")
    public String saveComment(@PathVariable(name = "postId") long postId,  @ModelAttribute Comment comment, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute("user");
        Post post = postService.getPostById(postId);
        commentservice.addComment(userSession, post, comment.getComments());
        return "redirect:/facebookHome";
    }


    @PostMapping("/saveEditedComment")
    public String saveEditedComment(@ModelAttribute("comment") Comment comment) {
        commentservice.updateComment(comment.getCommentId(),comment.getComments());
        return "redirect:/facebookHome";
    }



    @RequestMapping("/editComment/{postId}/{commentId}")
    public ModelAndView showEditCommentPage(@PathVariable(name = "postId") long postId, @PathVariable(name = "commentId") long commentId,Model model) {
        ModelAndView mav = new ModelAndView("Comment_edit2");
        Post post = postService.getPostById(postId);
        mav.addObject("post",post);
        mav.addObject("commentId",commentId);
        Comment comment = commentservice.get(commentId);
        mav.addObject("comment", comment);
        return mav;
    }






    @RequestMapping("/deleteComment/{commentId}")
    public String deleteComment(@PathVariable(name = "commentId") Long commentId) {
        commentservice.delete(commentId);
        return "redirect:/facebookHome";
    }

}
