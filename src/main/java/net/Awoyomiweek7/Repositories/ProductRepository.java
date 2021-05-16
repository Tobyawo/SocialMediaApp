package net.Awoyomiweek7.Repositories;

import net.Awoyomiweek7.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Product findByNameAndBrand(String name, String brand);


}
