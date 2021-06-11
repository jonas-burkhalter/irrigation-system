package ch.irrigation_system.sensor.administration;

import ch.irrigation_system.sensor.administration.model.Moisture;
import ch.irrigation_system.sensor.administration.model.Plant;
import ch.irrigation_system.sensor.administration.model.Pot;
import ch.irrigation_system.sensor.administration.model.Unit;
import ch.irrigation_system.sensor.administration.repository.MoistureRepository;
import ch.irrigation_system.sensor.administration.repository.PlantRepository;
import ch.irrigation_system.sensor.administration.repository.PotRepository;
import ch.irrigation_system.sensor.administration.repository.UnitRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class SeedingSensorAdministration {
    private final MoistureRepository moistureRepository;
    private final PotRepository potRepository;
    private final PlantRepository plantRepository;
    private final UnitRepository unitRepository;

    public SeedingSensorAdministration(MoistureRepository moistureRepository, PotRepository potRepository, PlantRepository plantRepository, UnitRepository unitRepository) {
        this.moistureRepository = moistureRepository;
        this.potRepository = potRepository;
        this.plantRepository = plantRepository;
        this.unitRepository = unitRepository;
    }

    @EventListener
    public void seed(ApplicationReadyEvent event) {
        Moisture high = new Moisture("High", 1600);
        Moisture medium = new Moisture("Medium", 1800);
        Moisture low = new Moisture("Low", 2000);

        moistureRepository.save(high);
        moistureRepository.save(medium);
        moistureRepository.save(low);

        // Plant //
        Plant petersilie = new Plant(medium, "Petersilie");
        Plant oregano = new Plant(medium, "Oregano");
        Plant majoran = new Plant(medium, "Majoran");

        plantRepository.save(petersilie);
        plantRepository.save(oregano);
        plantRepository.save(majoran);

        Plant rosemary = new Plant(medium, "Rosmarin");
        Plant thymine = new Plant(medium, "Thymian");
        Plant schnittlauch = new Plant(medium, "Schnittlauch");
        Plant salbei = new Plant(medium, "Salbei");

        plantRepository.save(rosemary);
        plantRepository.save(thymine);
        plantRepository.save(schnittlauch);
        plantRepository.save(salbei);

        // Units //
        Unit unit_links = new Unit("description", "Links");
        Unit unit_rechts = new Unit("description", "Rechts");

        unitRepository.save(unit_links);
        unitRepository.save(unit_rechts);

        // Pots //
        Pot pot_petersilie = new Pot("description", "Petersilie", unit_links, petersilie);
        Pot pot_oregano = new Pot("description", "Oregano", unit_links, oregano);
        Pot pot_majoran = new Pot("description", "Majoran", unit_links, majoran);

        potRepository.save(pot_petersilie);
        potRepository.save(pot_oregano);
        potRepository.save(pot_majoran);

        Pot pot_rosmarin = new Pot("description", "Rosmarin", unit_rechts, rosemary);
        Pot pot_thymian = new Pot("description", "Thymian", unit_rechts, thymine);
        Pot pot_schnittlauch = new Pot("description", "Schnittlauch", unit_rechts, schnittlauch);
        Pot pot_salbei = new Pot("description", "Salbei", unit_rechts, salbei);

        potRepository.save(pot_rosmarin);
        potRepository.save(pot_thymian);
        potRepository.save(pot_schnittlauch);
        potRepository.save(pot_salbei);
    }
}
