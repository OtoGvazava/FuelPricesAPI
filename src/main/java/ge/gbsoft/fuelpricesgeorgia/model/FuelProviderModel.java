package ge.gbsoft.fuelpricesgeorgia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelProviderModel {
    private String fuelProviderName;
    private LocalDate date;
    private List<FuelModel> fuelPrices;
}
