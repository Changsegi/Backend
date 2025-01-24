package hu.me.iit.storage.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "p_type")
    private String p_type;

    //@DateTimeFormat(pattern = "yyyy")
    @Column(name = "p_production_date")      //(name = "p_productionDate")
    private String p_production_date;

    /*
    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "planes")
    */

    @ManyToOne()
    @JoinColumn(name = "planes") // This is the actual foreign key column
    private Owner owner;











    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private Owner owner;

    /*
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    */
}
