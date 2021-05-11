//package net.codejava.Service;
//
//import net.codejava.Model.User;
//import net.codejava.Repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class UserService {
//
//    @Autowired
//   private  UserRepository userRepository;
//
//    public User getUserByEmail(String email){
//        return userRepository.getUserByEmail(email);
//    }
//
//
//    public void addUser (User user){
//        userRepository.save(user);
//    }
//
//    List<User> listUsers(String userName){return userRepository.findAll();}
////    public List<User> listUsers() {  return userRepository.findAll();
////    }
//
//
//
//    public void delete(long id) {
//        userRepository.deleteById(id);
//    }
//
//    public List<User> listAll() {
//        return userRepository.findAll();
//    }
//}
