package net.Awoyomiweek7.Repositories;

import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Model.CommentLike;
import net.Awoyomiweek7.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    CommentLike getCommentLikeByCommentAndUser(Comment comment, User user);
}
