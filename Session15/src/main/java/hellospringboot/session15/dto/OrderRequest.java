package hellospringboot.session15.dto;


import lombok.Data;


import java.util.List;


@Data
public class OrderRequest {


    private List<OrderItemRequest> items;


}