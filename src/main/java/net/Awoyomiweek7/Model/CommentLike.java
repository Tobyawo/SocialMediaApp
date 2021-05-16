package net.Awoyomiweek7.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @ManyToOne
    private Comment comment;

    @ManyToOne
    private User user;
}
