package hu.me.iit.storage.repositories;
import java.util.Optional;


import hu.me.iit.storage.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
    Optional<UserAccount> findByUsername(String username);

}
