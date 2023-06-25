package ge.gbsoft.fuelpricesgeorgia.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.gbsoft.fuelpricesgeorgia.entities.FuelPricesEntity;
import ge.gbsoft.fuelpricesgeorgia.model.FuelModel;
import ge.gbsoft.fuelpricesgeorgia.model.FuelProviderModel;
import ge.gbsoft.fuelpricesgeorgia.repositories.FuelPricesRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelPricesService {
    private final FuelPricesRepository fuelPricesRepository;

    FuelPricesService(FuelPricesRepository fuelPricesRepository) {
        this.fuelPricesRepository = fuelPricesRepository;
    }

    @SneakyThrows
    public FuelProviderModel getPrices(String fuelProvider) {
        ObjectMapper objectMapper = new ObjectMapper();
        FuelPricesEntity fuelPricesEntity = fuelPricesRepository.findFirstByFuelProviderIsOrderByIdDesc(fuelProvider);
        FuelProviderModel fuelProviderModel = new FuelProviderModel();
        fuelProviderModel.setFuelProviderName(fuelPricesEntity.getFuelProvider());
        fuelProviderModel.setDate(fuelPricesEntity.getPriceUpdateDate());
        fuelProviderModel.setFuelPrices(objectMapper.readValue(fuelPricesEntity.getFuelPrices(), new TypeReference<>() {}));
        return fuelProviderModel;
    }
}
