package ch.irrigation_system.sensor.data.controller.dto;

import ch.irrigation_system.sensor.data.model.Moisture;

import java.util.Date;

public class MoistureDto {
    private Date datetime;
    private long id;
    private String pot;
    private String unit;
    private int value;

    public MoistureDto(Moisture moisture) {
        this.datetime = moisture.getDatetime();
        this.id = moisture.getId();
        this.pot = moisture.getPot();
        this.unit = moisture.getUnit();
        this.value = moisture.getValue();
    }

    public Date getDatetime() {
        return datetime;
    }

    public int getValue() {
        return value;
    }
}
