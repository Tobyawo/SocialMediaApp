package net.Awoyomiweek7.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long commentId;

    @Column(nullable = false)
    private String comment;


    // Mapping the relationship btw comment to
    // other entity(Users and post) Many comments to One User
    @ManyToOne //Many Comment to One user
    private User user;


    @ManyToOne // Many comments to one post
    private Post post;

    @OneToMany //One comment can have many commentLikes
    private List<CommentLike> commentLike = new ArrayList<>();




}