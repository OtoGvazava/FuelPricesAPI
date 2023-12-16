package ge.gbsoft.fuelpricesgeorgia.services;

import ge.gbsoft.fuelpricesgeorgia.data.FuelProvider;
import ge.gbsoft.fuelpricesgeorgia.data.FuelType;
import ge.gbsoft.fuelpricesgeorgia.dto.FuelPriceDto;
import ge.gbsoft.fuelpricesgeorgia.dto.PriceDto;
import ge.gbsoft.fuelpricesgeorgia.dto.Response;
import ge.gbsoft.fuelpricesgeorgia.entities.FuelEntity;
import ge.gbsoft.fuelpricesgeorgia.dto.FuelDto;
import ge.gbsoft.fuelpricesgeorgia.entities.PriceEntity;
import ge.gbsoft.fuelpricesgeorgia.repositories.FuelRepository;
import ge.gbsoft.fuelpricesgeorgia.repositories.PriceRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FuelService {
    private final FuelRepository fuelRepository;
    private final PriceRepository priceRepository;

    FuelService(FuelRepository fuelRepository, PriceRepository priceRepository) {
        this.fuelRepository = fuelRepository;
        this.priceRepository = priceRepository;
    }

    public Response addFuel(FuelDto fuelDto) {
        Response response = new Response();
        return response.addData("fuel", this.fuelRepository.save(new FuelEntity(fuelDto)));
    }

    public Response getFuels() {
        Response response = new Response();
        return response.addData("fuels", this.fuelRepository.findAll());
    }

    public Response addPrice(int fuelId, PriceDto priceDto) {
        Response response = new Response();
        Optional<FuelEntity> optionalFuel = fuelRepository.findById(fuelId);
        if (optionalFuel.isPresent()) {
            return response.addData("price", this.priceRepository.save(new PriceEntity(optionalFuel.get(), priceDto)));
        } else return response.addData("error", "error");
    }

    public Response getPrices() {
        Response response = new Response();
        return response.addData("prices", priceRepository.findAll());
    }

    public Response getFuelPrices(FuelProvider fuelProvider,
                                  FuelType fuelType,
                                  Boolean selfService,
                                  String sortByDate) {
        FuelEntity exampleFuel = new FuelEntity();
        exampleFuel.setFuelProvider(fuelProvider);
        exampleFuel.setFuelType(fuelType);
        exampleFuel.setSelfService(selfService);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<FuelEntity> example = Example.of(exampleFuel, matcher);

        List<FuelEntity> fuels = fuelRepository.findAll(example);

        List<FuelPriceDto> fuelPriceDtoList = new ArrayList<>();

        for (FuelEntity fuelEntity : fuels) {
            FuelPriceDto fuelPriceDto = new FuelPriceDto();
            fuelPriceDto.setProvider(fuelEntity.getFuelProvider());
            fuelPriceDto.setType(fuelEntity.getFuelType());
            fuelPriceDto.setSelfService(fuelEntity.getSelfService());

            List<PriceEntity> prices = priceRepository.findAllByFuelOrderByDateDesc(fuelEntity);
            PriceEntity price = prices.get(0);
            fuelPriceDto.setPrice(price.getPrice());
            fuelPriceDto.setDate(price.getDate());

            fuelPriceDtoList.add(fuelPriceDto);
        }

        fuelPriceDtoList.sort(Comparator.comparingLong(fuelPrice -> fuelPrice.getDate().toEpochDay()));

        if (sortByDate != null && sortByDate.equals("asc")) {
            Collections.reverse(fuelPriceDtoList);
        }

        Response response = new Response();
        return response.addData("fuel_prices", fuelPriceDtoList);
    }
}