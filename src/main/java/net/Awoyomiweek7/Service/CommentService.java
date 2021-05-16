package net.Awoyomiweek7.Service;
import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Model.Post;
import net.Awoyomiweek7.Model.User;
import net.Awoyomiweek7.Repositories.CommentRepository;
import net.Awoyomiweek7.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void addComment(User user, Post post, String comments) {
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setComments(comments);

        commentRepository.save(comment);
    }



    public void updateComment(long commentId, String comments) {
        Comment comment = commentRepository.findByCommentId(commentId);
        comment.setComments(comments);
        commentRepository.save(comment);
    }



    public Comment get(long commentId) {
        return commentRepository.findById(commentId).get();
    }
    public void delete(long commentId) {
        //Comment comment = commentRepository.findByCommentId(commentId);
        commentRepository.deleteCommentByCommentId(commentId);
    }


    public void deleteComment(Long commentId) {
        try {
            //commentRepository.deleteCommentByCommentId(commentId);
            commentRepository.deleteById(commentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Comment getCommentById(long commentId) {
        return commentRepository.getCommentByCommentId(commentId);
    }



//    public List<Comment> listAllCommentByPostId(long postId) {
//
//        return  commentRepository.findCommentsByPostId(postId);
//    }
}
