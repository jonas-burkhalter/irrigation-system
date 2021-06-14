package ch.irrigation_system.sensor.administration.repository;

import ch.irrigation_system.sensor.administration.model.Unit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {
}
