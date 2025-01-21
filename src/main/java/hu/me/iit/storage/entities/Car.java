package hu.me.iit.storage.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "c_type")
    private String c_type;

    @Column(name = "c_production_date")
    private String c_production_date;

    @ManyToOne()
    @JoinColumn(name = "owner_id") // This is the actual foreign key column
    private Owner owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return c_type;
    }

    public void setModel(String model) {
        this.c_type = model;
    }

    public String getProductionDate() {
        return c_production_date;
    }
    public void setProductionDate(String productionDate) {
        this.c_production_date = productionDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }








    /*
    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "cars")
    private List<Owner> owners;

    */
}

