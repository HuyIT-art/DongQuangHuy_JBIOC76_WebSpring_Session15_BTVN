package hellospringboot.session15.controller;
import hellospringboot.session15.dto.RegisterRequest;
import hellospringboot.session15.entity.User;
import hellospringboot.session15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    UserService service;



    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequest request
    ){

        return service.register(request);

    }


}