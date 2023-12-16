package ge.gbsoft.fuelpricesgeorgia.dto;

import ge.gbsoft.fuelpricesgeorgia.data.FuelProvider;
import ge.gbsoft.fuelpricesgeorgia.data.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuelDto {
    private FuelProvider provider;
    private FuelType type;
    private boolean selfService;
}
