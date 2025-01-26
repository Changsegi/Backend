package hu.me.iit.storage.services;

import hu.me.iit.storage.repositories.UserAccountRepository;
import hu.me.iit.storage.user.UserAccount;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;


 /*

    protected String encode(String password){
        BCryptPasswordEncoder pc = new BCryptPasswordEncoder();
        pc.encode(password);
        return pc.encode(password);
    }



/*
    @Transactional
    public UserAccount createNewUser(UserAccount userAccount) throws IllegalArgumentException{
        /* Check if username is taken: */ /*
        if (userAccountRepository.findByUsername(userAccount.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username taken!");
        }
        UserAccount newAccount = new UserAccount(
                userAccount.getUsername(),
                encode(userAccount.getPassword()),
                new ArrayList<>(Arrays.asList("ROLE_USER")));
        return userAccountRepository.save(newAccount);
    }
*/
}
