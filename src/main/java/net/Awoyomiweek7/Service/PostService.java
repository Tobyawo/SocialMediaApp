package net.Awoyomiweek7.Service;
import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Model.Post;
import net.Awoyomiweek7.Model.Product;
import net.Awoyomiweek7.Model.User;
import net.Awoyomiweek7.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;


    public List<Post> listAll() {
        List<Post> listOfPost = postRepository.findAll(Sort.by(Sort.Direction.DESC, "postId"));
        return listOfPost;
    }


    public void save(Post post, User user) {
        post.setUser(user);
        postRepository.save(post);
    }

    public Post get(long postid) {
            return postRepository.findById(postid).get();
    }


    public void delete(long postId) {
        postRepository.deleteById(postId);
    }


    public void updatePostContentById(Post post) {
    }

    public Post getPostById(Long id){
        return postRepository.getPostByPostId(id);
    }

}
