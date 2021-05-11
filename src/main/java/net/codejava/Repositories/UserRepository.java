//package net.codejava.Repositories;
//
//import net.codejava.Model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.repository.NoRepositoryBean;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
////@NoRepositoryBean
////@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryRef")
//public interface UserRepository extends JpaRepository<User, Long> {
//    User getUserByEmail(String email);
////    Optional<User> listUsers();
//
////    void delete(String email);
//
//}