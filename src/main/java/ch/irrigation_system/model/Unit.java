package ch.irrigation_system.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "units")
public class Unit {
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "unit")
    private Set<Pot> pots;

    public Unit() {
    }

    public Unit(String description, String name) {
        this.description = description;
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pot> getPots() {
        return pots;
    }
}
