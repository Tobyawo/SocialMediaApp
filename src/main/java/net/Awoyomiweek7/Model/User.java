package net.Awoyomiweek7.Model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name="user2")
public class User {
    private Long userid;
    private String firstname;
    private String lastname;
    private String email;
    private String password;



    public User() {
    }

    public User(Long userid, String firstname, String lastname, String email, String password) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





        @OneToMany    // Defining the relationship: Mapping One User to many Post relationship
        private List<Post> post =new ArrayList<>();


        @OneToMany    // Defining the relationship: Mapping One User to many Post relationship
        private List<Comment> comment =new ArrayList<>();

        @OneToMany    // Defining the relationship: Mapping One User to many Post relationship
        private List<PostLike> postLike =new ArrayList<>();

        @OneToMany    // Defining the relationship: Mapping One User to many Post relationship
        private List<CommentLike> commentLike =new ArrayList<>();


}
