package net.codejava.Repositories;

import net.codejava.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Product findByNameAndBrand(String name, String brand);
//    User findByUsernameAndPassword(String username, String password);

}
