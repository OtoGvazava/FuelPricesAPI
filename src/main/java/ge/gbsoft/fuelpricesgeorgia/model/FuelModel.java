package ge.gbsoft.fuelpricesgeorgia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuelModel {
    private String name;
    private String price;
}
