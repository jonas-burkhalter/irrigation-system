package ch.irrigation_system.sensor.administration.repository;

import ch.irrigation_system.sensor.administration.model.Pot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotRepository extends CrudRepository<Pot, Long> {
}
