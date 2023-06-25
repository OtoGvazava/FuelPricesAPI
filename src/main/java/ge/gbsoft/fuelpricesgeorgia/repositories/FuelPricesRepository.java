package ge.gbsoft.fuelpricesgeorgia.repositories;

import ge.gbsoft.fuelpricesgeorgia.entities.FuelPricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelPricesRepository extends JpaRepository<FuelPricesEntity, Long> {
    FuelPricesEntity findFirstByFuelProviderIsOrderByIdDesc(String fuelProvider);
}
