package net.codejava.Service;


import net.codejava.Model.User2;
import net.codejava.Repositories.User2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {
    @Autowired
    private User2Repository user2Repository;
    public List<User2> listAll(){return user2Repository.findAll();}

    public void save(User2 user) { user2Repository.save(user);
    }


public User2 get(long id){
    return user2Repository.findById(id).get();}



    public void delete(long id) {
        user2Repository.deleteById(id);
    }
}




