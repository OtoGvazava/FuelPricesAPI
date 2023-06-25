package ge.gbsoft.fuelpricesgeorgia.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.gbsoft.fuelpricesgeorgia.model.FuelProviderModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.time.LocalDate;

@Table(name = "FUEL_PRICES")
@Entity
@Data
@NoArgsConstructor
public class FuelPricesEntity {
    @Id()
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FUEL_PROVIDER")
    private String fuelProvider;

    @Column(name = "PRICE_UPDATE_DATE")
    private LocalDate priceUpdateDate;

    @Column(name = "PRICES", columnDefinition = "json")
    private String fuelPrices;

    @SneakyThrows
    public FuelPricesEntity(FuelProviderModel fuelProviderModel) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.fuelProvider = fuelProviderModel.getFuelProviderName();
        this.priceUpdateDate = fuelProviderModel.getDate();
        this.fuelPrices = objectMapper.writeValueAsString(fuelProviderModel.getFuelPrices());
    }
}
