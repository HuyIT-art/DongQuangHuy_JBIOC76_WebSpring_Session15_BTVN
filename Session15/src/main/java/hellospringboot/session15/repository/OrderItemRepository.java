package hellospringboot.session15.repository;


import hellospringboot.session15.entity.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderItemRepository
        extends JpaRepository<OrderItem,Long>{


}