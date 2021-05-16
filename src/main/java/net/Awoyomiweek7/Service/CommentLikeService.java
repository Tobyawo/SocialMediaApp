//package net.Awoyomiweek7.Service;
//import net.Awoyomiweek7.Model.Comment;
//import net.Awoyomiweek7.Model.Post;
//import net.Awoyomiweek7.Model.PostLike;
//import net.Awoyomiweek7.Model.User;
//import net.Awoyomiweek7.Repositories.CommentLikeRepository;
//import net.Awoyomiweek7.Repositories.CommentRepository;
//import net.Awoyomiweek7.Repositories.PostLikeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class CommentLikeService {
//
//    @Autowired
//    CommentLikeRepository commentLikeRepository;
//
//    public void addLikes(Integer likes, Post post,User user) {
//        PostLike postLike = new PostLike();
//        // postLike.setLikes(likes);
//        postLike.setUser(user);
//        postLike.setPost(post);
//        commentLikeRepository.save(postLike);
//
//    }
//
//
//
//
//}
