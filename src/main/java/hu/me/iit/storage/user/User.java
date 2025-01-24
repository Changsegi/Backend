package hu.me.iit.storage.user;
/*
//import com.alibou.book.book.Book;
//import com.alibou.book.history.BookTransactionHistory;
//import com.alibou.book.role.Role;


import hu.me.iit.storage.role.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.persistence.FetchType.EAGER;



@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails {//}, Principal {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = EAGER)
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }


}
*/
