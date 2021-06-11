package ch.irrigation_system.sensor.administration.controller;

import ch.irrigation_system.sensor.administration.controller.dto.PotDto;
import ch.irrigation_system.sensor.administration.model.Pot;
import ch.irrigation_system.sensor.administration.repository.PotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/sensor/administration/pots")
public class PotController {
    private final PotRepository repository;

    public PotController(PotRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public void create(String description, String name) throws Exception {
        throw new Exception("Not implemented");
        // Pot pot = new Pot(description, name);
        // repository.save(pot);
    }

    @GetMapping(value = "/{id}")
    public PotDto read(@PathVariable long id) {
        Pot pot = repository.findById(id).get();
        return new PotDto(pot);
    }

    @GetMapping
    public List<PotDto> read() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(PotDto::new)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable long id, String description, String name) {
        Pot pot = repository.findById(id).get();

        pot.setDescription(description);
        pot.setName(name);

        repository.save(pot);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
