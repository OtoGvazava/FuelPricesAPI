package ge.gbsoft.fuelpricesgeorgia.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum FuelProvider {
    GULF("Gulf", "https://gulf.ge/en/fuel_prices"),
    ROMPETROL("Rompetrol", "https://www.rompetrol.ge/#pricelist");

    private final String name;
    private final String pricePageUrl;

    public static List<FuelProvider> getAllProvider() {
        return Arrays.stream(FuelProvider.values()).toList();
    }
}
