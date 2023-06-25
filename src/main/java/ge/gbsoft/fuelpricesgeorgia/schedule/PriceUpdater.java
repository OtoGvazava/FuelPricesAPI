package ge.gbsoft.fuelpricesgeorgia.schedule;


import ge.gbsoft.fuelpricesgeorgia.services.FuelPricesUpdateService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PriceUpdater {
    private final FuelPricesUpdateService fuelPricesUpdateService;

    PriceUpdater(FuelPricesUpdateService fuelPricesUpdateService) {
        this.fuelPricesUpdateService = fuelPricesUpdateService;
    }

    @Scheduled(fixedDelay = 1800000)
    public void updateAllProviderPrices() {
        fuelPricesUpdateService.addGulfPrices();
        fuelPricesUpdateService.addRompetrolPrices();
        System.out.println("Updated");
    }
}
