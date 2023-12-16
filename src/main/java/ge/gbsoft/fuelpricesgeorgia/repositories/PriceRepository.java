package ge.gbsoft.fuelpricesgeorgia.repositories;

import ge.gbsoft.fuelpricesgeorgia.entities.FuelEntity;
import ge.gbsoft.fuelpricesgeorgia.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
    List<PriceEntity> findAllByFuelOrderByDateDesc(FuelEntity fuel);
}
