package ch.irrigation_system.sensor.administration.repository;

import ch.irrigation_system.sensor.administration.model.Moisture;
import org.springframework.data.repository.CrudRepository;

public interface MoistureRepository extends CrudRepository<Moisture, Long> {
}
