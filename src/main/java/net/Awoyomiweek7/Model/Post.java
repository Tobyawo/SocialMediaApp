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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Column(nullable = false) // the column cannot take in null values
    private String postContent;

    // Mapping the relationship btw Post to
    // other entity(Users)
    @ManyToOne   //Defining the relationship: Mapping many Post to one User relationship
    private User user;

    @OneToMany // one post to many comment
    private List<Comment> comment = new ArrayList<>();

    @OneToMany
    private List<PostLike> likes = new ArrayList<>();









}