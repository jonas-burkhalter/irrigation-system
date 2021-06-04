package ch.irrigation_system.repository;

import ch.irrigation_system.model.Moisture;
import org.springframework.data.repository.CrudRepository;

public interface MoistureRepository extends CrudRepository<Moisture, Long> {
}
