package net.Awoyomiweek7.Service;


import net.Awoyomiweek7.Model.User;
import net.Awoyomiweek7.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository user2Repository;
    public List<User> listAll(){return user2Repository.findAll();}

    public void save(User user) { user2Repository.save(user);
    }


public User get(long id){
    return user2Repository.findById(id).get();}



    public void delete(long id) {
        user2Repository.deleteById(id);
    }

    public Optional<User> getUserById(long userid) {
        Optional<User> newuser = user2Repository.findById(userid);
        return newuser;
    }


    public User getUserByEmailAndPassword(String email, String password) {
        return user2Repository.getUserByEmailAndPassword(email, password);
    }

    public User getUserByEmail(String email) {
        return user2Repository.getUserByEmail(email);
    }
}




