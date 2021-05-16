package net.Awoyomiweek7.Repositories;

import net.Awoyomiweek7.Model.Post;

import net.Awoyomiweek7.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post getPostByPostId(Long id);



}
