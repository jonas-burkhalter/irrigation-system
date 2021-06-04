package ch.irrigation_system.repository;

import ch.irrigation_system.model.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
