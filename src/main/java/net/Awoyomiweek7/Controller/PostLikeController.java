package net.Awoyomiweek7.Controller;

import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Model.Post;
import net.Awoyomiweek7.Model.PostLike;
import net.Awoyomiweek7.Model.User;

import net.Awoyomiweek7.Service.CommentService;
import net.Awoyomiweek7.Service.PostLikeService;
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
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @PostMapping("/like/{postId}")
    public String likeIndex(@PathVariable("postId") Long postId, HttpSession session, PostLike like, Model model) {
        User userObj = (User) session.getAttribute("user");
        if (userObj == null) return "redirect:/login";
        Post post = postService.getPostById(postId);
        PostLike postLike = postLikeService.getPostLikeByPostAndUser(post, userObj);
        like.setPost(post);
        like.setUser(userObj);
        if (postLike == null) {
            postLikeService.addLike(like);
        } else {
            postLikeService.deleteLike(postLike);
        }
        return "redirect:/facebookHome";
    }
//
//    @PostMapping("/comment/like/{id}")
//    public String likeIndex(@PathVariable("id") Long id, HttpSession session, CommentLike like, Model model) {
//        User userObj = (User) session.getAttribute("user");
//        if (userObj == null) return "redirect:/login";
//        Comment comment = commentService.getCommentById(id);
//        CommentLike commentLike = commentLikeService.getCommentLikeByCommentAndUser(comment, userObj);
//        like.setComment(comment);
//        like.setUser(userObj);
//        if (commentLike == null) {
//            commentLikeService.addLike(like);
//        } else {
//            commentLikeService.deleteLike(like);
//        }
//        return "redirect:/home";
//    }




//    @PostMapping("/savePostLike/{postId}")
//    public String savePostLike(@PathVariable(name = "postId") long postId,HttpServletRequest request) {
//        System.out.println("i got here");
//
//        HttpSession session = request.getSession();
//        User userSession = (User) session.getAttribute("user");
//        Post post = postService.getPostById(postId);
//        int likes = 1;
//        System.err.println(userSession.getUserid() + " "+ post.getPostId() + " "+ likes);
//        postLikeService.addLikes(likes,post ,userSession );
//
//        return "redirect:/facebookHome";
//    }


}