package net.Awoyomiweek7.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor // covers for no arguments constructors
@AllArgsConstructor // covers for all arguments constructors
@Data
@Entity
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeId;


    @ManyToOne
    private Post post;

    @ManyToOne
    private  User user;




}
