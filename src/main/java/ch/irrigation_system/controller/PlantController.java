package ch.irrigation_system.controller;

import ch.irrigation_system.model.Pot;
import ch.irrigation_system.repository.PlantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/plant")
public class PlantController {
    private final PlantRepository plantRepository;

    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @PostMapping(value = "api/unit/{unitId}/plant")
    public void createPlant(@PathVariable int unitId, String name) {
        // Plant plant = new Plant(name, unit);
        // plantRepository.save(plant);
    }

    @GetMapping(value = "api/unit/{unitId}/plant/{id}")
    public Pot readPlant(@PathVariable int id) {
        return plantRepository.findById(id).get();
    }

    @GetMapping(value = "api/unit/{unitId}/plant")
    public Iterable<Pot> readPlant() {
        return plantRepository.findAll();
    }

    /*
    @PutMapping(value = "{id}")
    public void updatePlant(@PathVariable int unitId, @PathVariable int id, String name) {
        // return irrigationSystem.getUnit(id);
    }
    */

    @DeleteMapping(value = "api/unit/{unitId}/plant/{id}")
    public void deletePlant(@PathVariable int id) {
        plantRepository.deleteById(id);
    }
}
