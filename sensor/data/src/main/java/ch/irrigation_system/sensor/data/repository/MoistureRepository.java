package ch.irrigation_system.sensor.data.repository;

import ch.irrigation_system.sensor.data.model.Moisture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MoistureRepository extends CrudRepository<Moisture, Long> {
    List<Moisture> findByUnitAndPotAndDatetimeBetween(String unit, String pot, Date from, Date to);
}
