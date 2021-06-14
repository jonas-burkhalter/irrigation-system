package ch.irrigation_system.sensor.administration.controller.dto;

import ch.irrigation_system.sensor.administration.model.Moisture;
import ch.irrigation_system.sensor.administration.model.Plant;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MoistureDto {
    private String description;
    private long id;
    private Set<Plant> plants;
    private int value;

    public MoistureDto(Moisture moisture) {
        this.description = moisture.getDescription();
        this.id = moisture.getId();
        this.plants = moisture.getPlants();
        this.value = moisture.getValue();
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public List<Long> getPlantIds() {
        return plants
                .stream()
                .map(u -> u.getId())
                .collect(Collectors.toList());
    }

    public int getValue() {
        return value;
    }
}
