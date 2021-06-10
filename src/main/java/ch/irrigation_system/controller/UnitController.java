package ch.irrigation_system.controller;

import ch.irrigation_system.controller.dto.UnitDto;
import ch.irrigation_system.model.Unit;
import ch.irrigation_system.repository.UnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/units")
public class UnitController {
    private final UnitRepository unitRepository;

    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @PostMapping
    public void createUnit(String name) {
        Unit unit = new Unit(name);
        unitRepository.save(unit);
    }

    @GetMapping(value = "/{id}")
    public UnitDto readUnit(@PathVariable int id) {
        Unit unit = unitRepository.findById(id).get();
        return new UnitDto(unit);
    }

    @GetMapping
    public List<Unit> readUnit() {
        return StreamSupport
                .stream(unitRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /*
    @PutMapping(value = "/{id}")
    public void updateUnit(@PathVariable int id, String name) {
        // return irrigationSystem.getUnit(id);
    }
     */

    @DeleteMapping(value = "/{id}")
    public void deleteUnit(@PathVariable int id) {
        unitRepository.deleteById(id);
    }
}
