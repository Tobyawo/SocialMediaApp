package net.Awoyomiweek7.Repositories;

import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Service.CommentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Transactional
    void deleteCommentByCommentId(Long commentId);
    Comment findByCommentId(Long commentId);

    Comment getCommentByCommentId(Long commentId);
}
