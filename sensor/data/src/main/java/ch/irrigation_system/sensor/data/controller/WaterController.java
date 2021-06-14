package ch.irrigation_system.sensor.data.controller;

import ch.irrigation_system.sensor.data.controller.dto.WaterDto;
import ch.irrigation_system.sensor.data.model.Water;
import ch.irrigation_system.sensor.data.repository.WaterRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sensor/data/water")
public class WaterController {
    private final WaterRepository repository;

    public WaterController(WaterRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{unit}")
    public WaterDto read(@PathVariable String unit) {
        Water water = repository.findTopByUnitOrderByDatetime(unit);
        return new WaterDto(water);
    }
}
