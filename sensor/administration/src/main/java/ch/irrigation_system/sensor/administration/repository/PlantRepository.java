package ch.irrigation_system.sensor.administration.repository;

import ch.irrigation_system.sensor.administration.model.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
