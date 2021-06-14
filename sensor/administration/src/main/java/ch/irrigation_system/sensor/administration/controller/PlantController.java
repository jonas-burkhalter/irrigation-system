package ch.irrigation_system.sensor.administration.controller;

import ch.irrigation_system.sensor.administration.controller.dto.PlantDto;
import ch.irrigation_system.sensor.administration.model.Plant;
import ch.irrigation_system.sensor.administration.repository.PlantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/sensor/administration/plants")
public class PlantController {
    private final PlantRepository repository;

    public PlantController(PlantRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void create(String description, String name) throws Exception {
        throw new Exception("Not implemented");
        // Plant plant = new Plant(description, name);
        // repository.save(plant);
    }

    @GetMapping(value = "/{id}")
    public PlantDto read(@PathVariable long id) {
        Plant plant = repository.findById(id).get();
        return new PlantDto(plant);
    }

    @GetMapping
    public List<PlantDto> read() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(PlantDto::new)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable long id, String name) {
        Plant plant = repository.findById(id).get();

        plant.setName(name);

        repository.save(plant);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
