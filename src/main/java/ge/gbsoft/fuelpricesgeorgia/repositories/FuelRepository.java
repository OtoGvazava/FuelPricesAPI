package ge.gbsoft.fuelpricesgeorgia.repositories;

import ge.gbsoft.fuelpricesgeorgia.entities.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<FuelEntity, Integer> {
}
