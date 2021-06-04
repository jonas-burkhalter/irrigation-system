package ch.irrigation_system;

import ch.irrigation_system.model.Moisture;
import ch.irrigation_system.model.Plant;
import ch.irrigation_system.model.Pot;
import ch.irrigation_system.model.Unit;
import ch.irrigation_system.repository.PlantRepository;
import ch.irrigation_system.repository.PotRepository;
import ch.irrigation_system.repository.UnitRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class Seeding {
    private final PotRepository potRepository;
    private final PlantRepository plantRepository;
    private final UnitRepository unitRepository;

    public Seeding(PotRepository potRepository, PlantRepository plantRepository, UnitRepository unitRepository) {
        this.potRepository = potRepository;
        this.plantRepository = plantRepository;
        this.unitRepository = unitRepository;
    }

    @EventListener
    public void seed(ApplicationReadyEvent event) {
        Moisture high = new Moisture("High", 1600);
        Moisture medium = new Moisture("Medium", 1800);
        Moisture low = new Moisture("Low", 2000);

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
        Unit unit_links = new Unit("Links");
        Unit unit_rechts = new Unit("Rechts");

        unitRepository.save(unit_links);
        unitRepository.save(unit_rechts);

        // Pots //
        Pot pot_petersilie = new Pot("Petersilie", unit_links, petersilie);
        Pot pot_oregano = new Pot("Oregano", unit_links, oregano);
        Pot pot_majoran = new Pot("Majoran", unit_links, majoran);

        potRepository.save(pot_petersilie);
        potRepository.save(pot_oregano);
        potRepository.save(pot_majoran);

        Pot pot_rosmarin = new Pot("Rosmarin", unit_rechts, rosemary);
        Pot pot_thymian = new Pot("Thymian", unit_rechts, thymine);
        Pot pot_schnittlauch = new Pot("Schnittlauch", unit_rechts, schnittlauch);
        Pot pot_salbei = new Pot("Salbei", unit_rechts, salbei);

        potRepository.save(pot_rosmarin);
        potRepository.save(pot_thymian);
        potRepository.save(pot_schnittlauch);
        potRepository.save(pot_salbei);
    }
}