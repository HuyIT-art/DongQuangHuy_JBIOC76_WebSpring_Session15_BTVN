package hellospringboot.session15.controller;



import hellospringboot.session15.dto.OrderRequest;
import hellospringboot.session15.entity.Order;

import hellospringboot.session15.service.OrderService;


import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/orders")
public class OrderController {



    private final OrderService service;



    public OrderController(OrderService service){

        this.service = service;

    }



    @PostMapping
    public Order create(
            @RequestBody OrderRequest request
    ){


        return service.create(request);


    }



}