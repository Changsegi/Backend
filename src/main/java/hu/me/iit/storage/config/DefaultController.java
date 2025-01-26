package hu.me.iit.storage.config;


import hu.me.iit.storage.repositories.UserAccountRepository;
import hu.me.iit.storage.user.UserAccount;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
public class DefaultController implements ErrorController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private static final String PATH = "/error";


    protected String encode(String password){
        BCryptPasswordEncoder pc = new BCryptPasswordEncoder();
        pc.encode(password);
        return pc.encode(password);
    }



    @RequestMapping(value = PATH)
    public String error() {
        return "forward:/login.html";
    }
    //@Override
    public String getErrorPath() {
        return PATH;
    }

    /* Default user for testing */
    @PostConstruct
    public void init() {
        userAccountRepository.deleteAll();
        UserAccount userAdmin = new UserAccount(
                "admin", "{noop}123",
                new ArrayList<>(Arrays.asList("ROLE_ADMIN")));
        UserAccount userSecret = new UserAccount(
                "secret",
                "{noop}123",
                new ArrayList<>(Arrays.asList("ROLE_SECRET")));
        UserAccount user = new UserAccount(
                "user",
                "{noop}123",
                new ArrayList<>(Arrays.asList("ROLE_USER")));

        userAccountRepository.save(userAdmin);
        userAccountRepository.save(userSecret);
        userAccountRepository.save(user);
    }
}
