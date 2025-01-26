package hu.me.iit.storage.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class LoginController {


    @GetMapping("/user")
    public Principal getUserPrincipal(Principal user) {
        System.out.println(user);

        return user;
    }
}
