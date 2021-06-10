package ch.irrigation_system.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "moistures")
public class Moisture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int value;
    @OneToMany(mappedBy = "moisture")
    private Set<Plant> plants;

    public Moisture(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public Moisture() {

    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public Set<Plant> getPlants() {
        return plants;
    }

    @Override
    public String toString() {
        return "Moisture{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
