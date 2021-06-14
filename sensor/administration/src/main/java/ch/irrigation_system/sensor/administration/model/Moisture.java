package ch.irrigation_system.sensor.administration.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "moisture")
public class Moisture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @OneToMany(mappedBy = "moisture")
    private Set<Plant> plants;

    private int value;

    public Moisture() {
    }

    public Moisture(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Plant> getPlants() {
        return plants;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
