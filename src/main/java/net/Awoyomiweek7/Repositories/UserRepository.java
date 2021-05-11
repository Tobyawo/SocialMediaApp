package net.Awoyomiweek7.Repositories;

import net.Awoyomiweek7.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmailAndPassword(String email, String password);

    User getUserByEmail(String email);
}
