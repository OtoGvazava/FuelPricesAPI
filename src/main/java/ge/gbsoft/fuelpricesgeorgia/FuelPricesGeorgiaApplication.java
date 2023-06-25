package ge.gbsoft.fuelpricesgeorgia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FuelPricesGeorgiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(FuelPricesGeorgiaApplication.class, args);
    }

}
