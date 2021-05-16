package net.Awoyomiweek7.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor // covers for no arguments constructors
@AllArgsConstructor // covers for all arguments constructors
@Data
@Entity
@Table(name = "likes")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
//    @Column(nullable = false)
//    private int likes;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;


    @Override
    public String toString() {
        return "PostLike{" +
                "likeId=" + id +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
