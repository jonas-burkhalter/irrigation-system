package ch.irrigation_system.sensor.administration.controller;

import ch.irrigation_system.sensor.administration.controller.dto.MoistureDto;
import ch.irrigation_system.sensor.administration.model.Moisture;
import ch.irrigation_system.sensor.administration.repository.MoistureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/sensor/administration/moisture")
public class MoistureController {
    private final MoistureRepository repository;

    public MoistureController(MoistureRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void create(String description, int value) {
        Moisture moisture = new Moisture(description, value);
        repository.save(moisture);
    }

    @GetMapping(value = "/{id}")
    public MoistureDto read(@PathVariable long id) {
        Moisture moisture = repository.findById(id).get();
        return new MoistureDto(moisture);
    }

    @GetMapping
    public List<MoistureDto> read() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(MoistureDto::new)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable long id, String description, int value) {
        Moisture moisture = repository.findById(id).get();

        moisture.setDescription(description);
        moisture.setValue(value);

        repository.save(moisture);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
