package ge.gbsoft.fuelpricesgeorgia.dto;

import ge.gbsoft.fuelpricesgeorgia.data.FuelProvider;
import ge.gbsoft.fuelpricesgeorgia.data.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuelPriceDto {
    private FuelProvider provider;
    private FuelType type;
    private boolean selfService;
    private double price;
    private LocalDate date;
}
