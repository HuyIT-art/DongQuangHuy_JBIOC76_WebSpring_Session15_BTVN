package hellospringboot.session15.service;



import hellospringboot.session15.dto.OrderRequest;
import hellospringboot.session15.entity.*;

import hellospringboot.session15.repository.*;


import org.springframework.stereotype.Service;



@Service
public class OrderService {



    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;



    public OrderService(
            OrderRepository orderRepository,
            ProductRepository productRepository
    ){

        this.orderRepository = orderRepository;

        this.productRepository = productRepository;

    }




    public Order create(OrderRequest request){


        Order order = new Order();


        order.setStatus("PENDING");


        double total=0;



        for(var itemRequest : request.getItems()){



            Product product =
                    productRepository
                            .findById(itemRequest.getProductId())
                            .orElseThrow();



            OrderItem item = new OrderItem();


            item.setProduct(product);


            item.setQuantity(
                    itemRequest.getQuantity()
            );


            item.setPriceBuy(
                    product.getPrice().doubleValue()
            );



            total += product.getPrice().doubleValue()
                    * itemRequest.getQuantity();



            item.setOrder(order);



        }



        order.setTotalMoney(total);



        return orderRepository.save(order);



    }



}