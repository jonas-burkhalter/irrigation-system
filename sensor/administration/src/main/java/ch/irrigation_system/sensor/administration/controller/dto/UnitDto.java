package ch.irrigation_system.sensor.administration.controller.dto;

import ch.irrigation_system.sensor.administration.model.Pot;
import ch.irrigation_system.sensor.administration.model.Unit;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UnitDto {
    private String description;
    private long id;
    private String name;
    private Set<Pot> pots;

    public UnitDto(Unit unit) {
        this.description = unit.getDescription();
        this.id = unit.getId();
        this.name = unit.getName();
        this.pots = unit.getPots();
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

    public List<Long> getPotIds() {
        return pots
                .stream()
                .map(u -> u.getId())
                .collect(Collectors.toList());
    }
}
