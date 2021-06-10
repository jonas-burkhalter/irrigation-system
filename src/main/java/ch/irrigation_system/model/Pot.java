package ch.irrigation_system.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pots")
public class Pot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String name;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    public Pot(String name, Unit unit, Plant plant) {
        this.name = name;
        this.unit = unit;
        this.plant = plant;
    }

    public Pot() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    public Plant getPlant() {
        return plant;
    }
}
