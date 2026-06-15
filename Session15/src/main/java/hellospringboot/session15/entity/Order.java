package hellospringboot.session15.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name="orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // người đặt hàng

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;



    private LocalDateTime createdDate;



    private String status;



    private Double totalMoney;



    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private List<OrderItem> items;


}