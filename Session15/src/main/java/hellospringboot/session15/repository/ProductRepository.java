package hellospringboot.session15.repository;


import hellospringboot.session15.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository
        extends JpaRepository<Product,Long>{


}