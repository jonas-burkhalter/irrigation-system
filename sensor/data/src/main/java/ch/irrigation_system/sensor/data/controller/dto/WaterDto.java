package ch.irrigation_system.sensor.data.controller.dto;

import ch.irrigation_system.sensor.data.model.Water;

import java.util.Date;

public class WaterDto {
    private Date datetime;
    private long id;
    private String unit;
    private int value;

    public WaterDto(Water water) {
        this.datetime = water.getDatetime();
        this.id = water.getId();
        this.unit = water.getUnit();
        this.value = water.getValue();
    }

    public Date getDatetime() {
        return datetime;
    }

    public int getValue() {
        return value;
    }
}
