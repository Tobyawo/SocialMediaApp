package net.Awoyomiweek7.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.action.internal.OrphanRemovalAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "comment_id")
    private Long commentId;

    @Column(nullable = false)
    private String comments;


    // Mapping the relationship btw comment to
    // other entity(Users and post) Many comments to One User
    @ManyToOne //Many Comment to One user
    @JoinColumn(name = "user_id")
    private User user;


    //Code begins


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;



    //End here

//    @OneToMany //One comment can have many commentLikes
//    private List<CommentLike> commentLike = new ArrayList<>();




}
