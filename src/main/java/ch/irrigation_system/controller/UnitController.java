package ch.irrigation_system.controller;

import ch.irrigation_system.model.Unit;
import ch.irrigation_system.repository.UnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
//@RequestMapping(path = "/api/units")
public class UnitController {
    private final UnitRepository unitRepository;

    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @PostMapping(value = "/api/units")
    public void createUnit(String name) {
        Unit unit = new Unit(name);
        unitRepository.save(unit);
    }

    @GetMapping(value = "/api/units/{id}")
    public Unit readUnit(@PathVariable int id) {
        return unitRepository.findById(id).get();
    }

    @GetMapping(value = "/api/units")
    public List<Unit> readUnit() {
        List<Unit> units = StreamSupport
                .stream(unitRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return units;
    }

    /*
    @PutMapping(value = "{id}")
    public void updateUnit(@PathVariable int id, String name) {
        // return irrigationSystem.getUnit(id);
    }
     */

    @DeleteMapping(value = "/api/units/{id}")
    public void deleteUnit(@PathVariable int id) {
        unitRepository.deleteById(id);
    }
}
