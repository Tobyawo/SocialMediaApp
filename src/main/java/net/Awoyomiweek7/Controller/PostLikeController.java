package net.Awoyomiweek7.Controller;

import net.Awoyomiweek7.Model.*;

import net.Awoyomiweek7.Service.CommentLikeService;
import net.Awoyomiweek7.Service.CommentService;
import net.Awoyomiweek7.Service.PostLikeService;
import net.Awoyomiweek7.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



@Controller
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @Autowired
    CommentLikeService commentLikeService;

    @PostMapping("/savePostLikes/{PostId}")
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
        return "redirect:/fbindex";
    }

    @PostMapping("/saveCommentLikes/{commentId}")
    public String likeIndex(@PathVariable("commentId") Long commentId, HttpSession session, CommentLike like, Model model) {
        User userObj = (User) session.getAttribute("user");
        if (userObj == null) return "redirect:/login";
        Comment comment = commentService.getCommentById(commentId);
        CommentLike commentLike = commentLikeService.getCommentLikeByPostAndUser(comment, userObj);
        like.setComment(comment);
        like.setUser(userObj);
        if (commentLike == null) {
            commentLikeService.addLike(like);
        } else {
            commentLikeService.deleteLike(like);
        }
        return "redirect:/home";
    }




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