package net.Awoyomiweek7.Repositories;

import net.Awoyomiweek7.Model.Post;
import net.Awoyomiweek7.Model.PostLike;
import net.Awoyomiweek7.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    PostLike getPostLikeByPostAndAndUser(Post post, User user);
    void deleteAllByPostAndUser(Post post, User user);

}




