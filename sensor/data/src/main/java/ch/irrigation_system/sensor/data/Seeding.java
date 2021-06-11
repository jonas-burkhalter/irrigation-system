package ch.irrigation_system.sensor.data;

import ch.irrigation_system.sensor.data.model.Moisture;
import ch.irrigation_system.sensor.data.repository.MoistureRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Profile("dev")
public class Seeding {
    private final MoistureRepository moistureRepository;

    public Seeding(MoistureRepository moistureRepository) {
        this.moistureRepository = moistureRepository;
    }

    @EventListener
    public void seed(ApplicationReadyEvent event) {
        createMoisture(1000,"alpha", "ironman");
        createMoisture(1000,"beta", "ironman");
        createMoisture(1000,"gamma", "ironman");
        createMoisture(1000,"delta", "ironman");
        createMoisture(1000,"epsilon", "ironman");

        createMoisture(1000,"alpha", "hulk");
        createMoisture(1000,"beta", "hulk");
        createMoisture(1000,"gamma", "hulk");
        createMoisture(1000,"delta", "hulk");
        createMoisture(1000,"epsilon", "hulk");
    }

    private void createMoisture(int count, String pot, String unit) {
        for (int i = 0; i < count; i++) {
            Date datetime = new Date(System.currentTimeMillis() - i * 1000);
            int value = (int) ((Math.random() * 4095));
            Moisture moisture = new Moisture(datetime, pot, unit, value);
            moistureRepository.save(moisture);
        }
    }
}
