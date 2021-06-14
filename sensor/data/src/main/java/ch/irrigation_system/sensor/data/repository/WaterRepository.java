package ch.irrigation_system.sensor.data.repository;

import ch.irrigation_system.sensor.data.model.Water;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterRepository extends CrudRepository<Water, Long> {
    Water findTopByUnitOrderByDatetime(String unit);
}
