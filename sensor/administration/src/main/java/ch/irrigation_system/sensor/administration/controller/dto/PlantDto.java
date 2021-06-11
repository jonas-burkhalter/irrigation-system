package ch.irrigation_system.sensor.administration.controller.dto;

import ch.irrigation_system.sensor.administration.model.Moisture;
import ch.irrigation_system.sensor.administration.model.Plant;
import ch.irrigation_system.sensor.administration.model.Pot;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlantDto {
    private long id;
    private Moisture moisture;
    private String name;
    private Set<Pot> pots;

    public PlantDto(Plant plant) {
        this.id = plant.getId();
        this.moisture = plant.getMoisture();
        this.name = plant.getName();
        this.pots = plant.getPots();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getMoistureId() {
        return moisture.getId();
    }

    public List<Long> getPotIds() {
        return pots
                .stream()
                .map(u -> u.getId())
                .collect(Collectors.toList());
    }
}
