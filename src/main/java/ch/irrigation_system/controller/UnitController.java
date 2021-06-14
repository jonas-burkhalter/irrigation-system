package ch.irrigation_system.controller;

import ch.irrigation_system.controller.dto.UnitDto;
import ch.irrigation_system.model.Unit;
import ch.irrigation_system.repository.UnitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/units")
public class UnitController {
    private final UnitRepository repository;

    public UnitController(UnitRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void create(String description, String name) {
        Unit unit = new Unit(description, name);
        repository.save(unit);
    }

    @GetMapping(value = "/{id}")
    public UnitDto read(@PathVariable long id) throws Exception {
        Unit unit = repository.findById(id).get();
        return new UnitDto(unit);
    }

    @GetMapping
    public List<UnitDto> read() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(UnitDto::new)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable long id, String description, String name) {
        Unit unit = repository.findById(id).get();

        unit.setDescription(description);
        unit.setName(name);

        repository.save(unit);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
