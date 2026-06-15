package hellospringboot.session15.controller;


import hellospringboot.session15.entity.Product;
import hellospringboot.session15.service.ProductService;


import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductService service;


    public ProductController(ProductService service){

        this.service = service;

    }



    // ai cũng xem được

    @GetMapping
    public List<Product> getAll(){

        return service.findAll();

    }



    // ADMIN STAFF

    @PostMapping
    public Product create(
            @RequestBody Product product
    ){

        return service.create(product);

    }



    @PutMapping("/{id}")
    public Product update(
            @PathVariable Long id,
            @RequestBody Product product
    ){

        return service.update(id,product);

    }




    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id
    ){

        service.delete(id);

        return "deleted";

    }


}