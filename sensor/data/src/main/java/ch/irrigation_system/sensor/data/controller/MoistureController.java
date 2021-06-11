package ch.irrigation_system.sensor.data.controller;

import ch.irrigation_system.sensor.data.controller.dto.MoistureDto;
import ch.irrigation_system.sensor.data.model.Moisture;
import ch.irrigation_system.sensor.data.repository.MoistureRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/sensor/data/moisture")
public class MoistureController {
    private final MoistureRepository repository;

    public MoistureController(MoistureRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{unit}/{pot}/{from}/{to}")
    public List<MoistureDto> read(@PathVariable String unit, @PathVariable String pot, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date from, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date to) {
        return StreamSupport
                .stream(repository.findByUnitAndPotAndDatetimeBetween(unit, pot, from, to).spliterator(), false)
                .map(MoistureDto::new)
                .collect(Collectors.toList());
    }
}
