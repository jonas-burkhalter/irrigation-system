package ch.irrigation_system.sensor.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "water")
public class Water {
    private Date datetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String unit;

    private int value;

    public Water() {

    }

    public Water(Date datetime, String unit, int value) {
        this.datetime = datetime;
        this.unit = unit;
        this.value = value;
    }

    public Date getDatetime() {
        return datetime;
    }

    public long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public int getValue() {
        return value;
    }
}
