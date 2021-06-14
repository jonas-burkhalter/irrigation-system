package ch.irrigation_system.sensor.administration.model;

import javax.persistence.*;

@Entity
@Table(name = "pots")
public class Pot {
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;


    public Pot() {
    }

    public Pot(String description, String name, Unit unit, Plant plant) {
        this.description = description;
        this.name = name;
        this.unit = unit;
        this.plant = plant;
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

    public Plant getPlant() {
        return plant;
    }

    public Unit getUnit() {
        return unit;
    }
}
