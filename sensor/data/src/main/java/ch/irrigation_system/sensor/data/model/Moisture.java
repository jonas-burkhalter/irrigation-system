package ch.irrigation_system.sensor.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "moisture")
public class Moisture {
    private Date datetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String pot;

    private String unit;

    private int value;

    public Moisture() {

    }

    public Moisture(Date datetime, String pot, String unit, int value) {
        this.datetime = datetime;
        this.pot = pot;
        this.unit = unit;
        this.value = value;
    }

    public Date getDatetime() {
        return datetime;
    }

    public long getId() {
        return id;
    }

    public String getPot() {
        return pot;
    }

    public String getUnit() {
        return unit;
    }

    public int getValue() {
        return value;
    }
}
