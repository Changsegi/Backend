package hu.me.iit.storage.entities;

import jakarta.persistence.*;
import lombok.*;
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

    @ManyToOne
    @JoinColumn(name = "owner_id") // This is the actual foreign key column
    private Owner owner;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return p_type;
    }

    public void setModel(String model) {
        this.p_type = model;
    }

    public String getProductionDate() {
        return p_production_date;
    }
    public void setProductionDate(String productionDate) {
        this.p_production_date = productionDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }












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
