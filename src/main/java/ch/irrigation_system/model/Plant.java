package ch.irrigation_system.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "plant")
    private Set<Pot> pots;

    @ManyToOne
    @JoinColumn(name = "moisture_id", nullable = false)
    private Moisture moisture;

    public Plant(Moisture moisture, String name) {
        this.moisture = moisture;
        this.name = name;
    }
}
