package ge.gbsoft.fuelpricesgeorgia.controllers;

import ge.gbsoft.fuelpricesgeorgia.data.FuelProvider;
import ge.gbsoft.fuelpricesgeorgia.model.FuelProviderModel;
import ge.gbsoft.fuelpricesgeorgia.services.FuelPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FuelPriceController {
    FuelPricesService fuelPricesService;

    @Autowired
    FuelPriceController(FuelPricesService fuelPricesService) {
        this.fuelPricesService = fuelPricesService;
    }

    @GetMapping("fuel/prices/{provider}")
    public FuelProviderModel getPrices(@PathVariable String provider) {
        return fuelPricesService.getPrices(provider);
    }

    @GetMapping("fuel/prices")
    public List<FuelProviderModel> getAllPrices() {
        return FuelProvider.getAllProvider().stream().map(fuelProvider -> getPrices(fuelProvider.getName())).toList();
    }
}
