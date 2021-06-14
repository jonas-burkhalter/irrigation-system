package ch.irrigation_system.sensor.administration.controller.dto;

import ch.irrigation_system.sensor.administration.model.Plant;
import ch.irrigation_system.sensor.administration.model.Pot;
import ch.irrigation_system.sensor.administration.model.Unit;

public class PotDto {
    private String description;
    private long id;
    private String name;
    private Plant plant;
    private Unit unit;

    public PotDto(Pot pot) {
        this.description = pot.getDescription();
        this.id = pot.getId();
        this.name = pot.getName();
        this.plant = pot.getPlant();
        this.unit = pot.getUnit();
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPlantId() {
        return plant.getId();
    }

    public long getUnitId() {
        return unit.getId();
    }
}
