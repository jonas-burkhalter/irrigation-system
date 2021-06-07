package ch.irrigation_system.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "units")
public class Unit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String name;

  //  @OneToMany(mappedBy = "unit")
   // private Set<Pot> pots;

    public Unit(String name) {
        this.name = name;
    }

    public Unit(int id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public Unit() {

    }
}
