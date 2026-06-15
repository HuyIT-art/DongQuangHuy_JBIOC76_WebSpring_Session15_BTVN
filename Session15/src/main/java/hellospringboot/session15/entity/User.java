package hellospringboot.session15.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String phone;


    private String email;


    private String password;


    private String role;


}