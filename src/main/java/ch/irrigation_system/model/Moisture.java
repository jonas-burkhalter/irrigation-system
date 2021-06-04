package ch.irrigation_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "moistures")
public class Moisture {
    @Id
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
}
