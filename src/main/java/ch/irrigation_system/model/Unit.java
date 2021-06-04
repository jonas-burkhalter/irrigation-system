package ch.irrigation_system.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "unit")
    private Set<Pot> pots;

    public Unit(String name) {
        this.name = name;
    }

    public Unit() {
    }
}
