package net.Awoyomiweek7.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false) // the column cannot take in null values
    private String postContent;



    // Mapping the relationship btw Post to
    // other entity(Users)
    @ManyToOne   //Defining the relationship: Mapping many Post to one User relationship
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post",cascade=CascadeType.ALL, fetch = FetchType.EAGER)  // one post to many comment
    private Set<Comment> comments;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    private List<PostLike> likes = new ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postContent='" + postContent + '\'' +
                ", user=" + user +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}