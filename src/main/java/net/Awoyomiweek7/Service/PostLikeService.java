package net.Awoyomiweek7.Service;
import net.Awoyomiweek7.Model.Comment;
import net.Awoyomiweek7.Model.Post;
import net.Awoyomiweek7.Model.PostLike;
import net.Awoyomiweek7.Model.User;
import net.Awoyomiweek7.Repositories.CommentRepository;
import net.Awoyomiweek7.Repositories.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostLikeService {

    @Autowired
    PostLikeRepository postLikeRepository;

//    public void addLikes(Integer likes, Post post,User user) {
//        PostLike postLike = new PostLike();
//       // postLike.setLikes(likes);
//        postLike.setUser(user);
//        postLike.setPost(post);
//        postLikeRepository.save(postLike);
//
//    }

        public PostLike getPostLikeByPostAndUser(Post post, User user) {
            return postLikeRepository.getPostLikeByPostAndAndUser(post, user);
        }
        public void addLike(PostLike like) {
            postLikeRepository.save(like);
        }
        public void deleteLike(PostLike like) {
            postLikeRepository.delete(like);
        }
    public void deleteAllPostLike(Post post, User user) {
        postLikeRepository.deleteAllByPostAndUser(post, user);
    }



}
