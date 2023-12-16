package ge.gbsoft.fuelpricesgeorgia.controllers;

import ge.gbsoft.fuelpricesgeorgia.data.FuelProvider;
import ge.gbsoft.fuelpricesgeorgia.data.FuelType;
import ge.gbsoft.fuelpricesgeorgia.dto.FuelDto;
import ge.gbsoft.fuelpricesgeorgia.dto.PriceDto;
import ge.gbsoft.fuelpricesgeorgia.dto.Response;
import ge.gbsoft.fuelpricesgeorgia.services.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FuelController {
    FuelService fuelService;

    @Autowired
    FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @PostMapping("fuel")
    public Response addFuel(@RequestBody FuelDto fuelDto) {
        return fuelService.addFuel(fuelDto);
    }

    @GetMapping("fuels")
    public Response getFuels() {
        return fuelService.getFuels();
    }

    @PostMapping("price")
    public Response addPrice(@RequestParam("fuelId") int fuelId, @RequestBody PriceDto priceDto) {
        return fuelService.addPrice(fuelId, priceDto);
    }

    @GetMapping("prices")
    public Response getPrices() {
        return fuelService.getPrices();
    }

    @GetMapping("fuel_prices")
    public Response getFuelPrices(
            @RequestParam(value = "fuelProvider", required = false) FuelProvider fuelProvider,
            @RequestParam(value = "fuelType", required = false) FuelType fuelType,
            @RequestParam(value = "selfService", required = false) Boolean selfService,
            @RequestParam(value = "sortByDate", required = false) String sortByDate) {
        return fuelService.getFuelPrices(fuelProvider, fuelType, selfService, sortByDate);
    }
}