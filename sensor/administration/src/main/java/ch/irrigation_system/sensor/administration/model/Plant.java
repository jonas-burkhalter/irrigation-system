package ch.irrigation_system.sensor.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "plants")
public class Plant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "moisture_id", nullable = false)
    private Moisture moisture;

    private String name;

    @OneToMany(mappedBy = "plant")
    private Set<Pot> pots;

    public Plant(Moisture moisture, String name) {
        this.moisture = moisture;
        this.name = name;
    }

    public Plant() {
    }

    public Long getId() {
        return id;
    }

    public Moisture getMoisture() {
        return moisture;
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
