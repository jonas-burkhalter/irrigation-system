package ch.irrigation_system.sensor.data.repository;

import ch.irrigation_system.sensor.data.model.Moisture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MoistureRepository extends CrudRepository<Moisture, Long> {
    List<Moisture> findByUnitAndPotAndDatetimeBetween(String unit, String pot, Date from, Date to);
}
