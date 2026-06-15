package hellospringboot.session15.service;


import hellospringboot.session15.entity.Product;
import hellospringboot.session15.repository.ProductRepository;


import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ProductService {



    private final ProductRepository repository;



    public ProductService(ProductRepository repository){

        this.repository = repository;

    }



    // xem danh sách

    public List<Product> findAll(){

        return repository.findAll();

    }



    // thêm

    public Product create(Product product){

        return repository.save(product);

    }



    // sửa

    public Product update(
            Long id,
            Product product
    ){


        Product old =
                repository.findById(id)
                        .orElseThrow();



        old.setName(product.getName());

        old.setPrice(product.getPrice());

        old.setDescription(product.getDescription());

        old.setSize(product.getSize());

        old.setToppings(product.getToppings());


        return repository.save(old);

    }



    // xóa

    public void delete(Long id){

        repository.deleteById(id);

    }



}