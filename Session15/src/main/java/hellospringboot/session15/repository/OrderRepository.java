package hellospringboot.session15.repository;


import hellospringboot.session15.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository
        extends JpaRepository<Order,Long>{


}