package ch.irrigation_system.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "plants")
public class Plant implements Serializable {
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

    public Plant() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Pot> getPots() {
        return pots;
    }

    public Moisture getMoisture() {
        return moisture;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
