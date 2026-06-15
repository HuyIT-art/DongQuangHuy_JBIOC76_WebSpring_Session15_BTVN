package hellospringboot.session15.service;


import hellospringboot.session15.dto.RegisterRequest;
import hellospringboot.session15.entity.User;
import hellospringboot.session15.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {


    @Autowired
    UserRepository repository;


    @Autowired
    PasswordEncoder encoder;



    public User register(RegisterRequest request){


        if(repository.existsByEmail(request.getEmail())){

            throw new RuntimeException("Email đã tồn tại");

        }


        User user=new User();


        user.setEmail(request.getEmail());

        user.setPhone(request.getPhone());


        user.setPassword(
                encoder.encode(request.getPassword())
        );


        user.setRole("ROLE_USER");


        return repository.save(user);


    }


}