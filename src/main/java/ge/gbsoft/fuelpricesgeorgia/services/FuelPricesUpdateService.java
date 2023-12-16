//package ge.gbsoft.fuelpricesgeorgia.services;
//
//import ge.gbsoft.fuelpricesgeorgia.data.FuelProvider;
//import ge.gbsoft.fuelpricesgeorgia.entities.FuelEntity;
//import ge.gbsoft.fuelpricesgeorgia.dto.FuelModel;
//import ge.gbsoft.fuelpricesgeorgia.repositories.FuelRepository;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FuelPricesUpdateService implements AutoCloseable {
//    WebDriver driver;
//    FuelRepository fuelRepository;
//
//    @Autowired
//    public FuelPricesUpdateService(FuelRepository fuelRepository) {
//        this.fuelRepository = fuelRepository;
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//    }
//
//    public void addGulfPrices() {
//        FuelProvider GULF = FuelProvider.GULF;
//        driver.get(GULF.getPricePageUrl());
//
//        List<FuelModel> fuelModelList = new ArrayList<>();
//        for (int i = 2; i < 9; i++) {
//            String name = driver.findElement(By.xpath(String.format("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/table/thead/tr/td[%s]/div/a/span[1]", i))).getText();
//            String price = driver.findElement(By.xpath(String.format("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[%s]/span", i))).getText();
//            fuelModelList.add(new FuelModel(name, price));
//        }
//
//        String dateString = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/span")).getText();
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
//        LocalDate date = LocalDate.parse(dateString, formatter);
//
//        fuelRepository.save(new FuelEntity(new FuelProviderModel(GULF.getName(), date, fuelModelList)));
//    }
//
//    public void addRompetrolPrices() {
//        FuelProvider ROMPETROL = FuelProvider.ROMPETROL;
//        driver.get(ROMPETROL.getPricePageUrl());
//
//        List<FuelModel> fuelModelList = new ArrayList<>();
//        for (int i=1; i<6; i++) {
//            WebElement element = driver.findElement(By.xpath(String.format("//*[@id=\"homepage\"]/section[6]/div/div/div/div/div/table/tbody/tr[%s]", i)));
//            String name = element.findElement(By.xpath("./td[1]")).getText();
//            String price = element.findElement(By.xpath("./td[2]")).getText();
//            fuelModelList.add(new FuelModel(name, price));
//        }
//
//        fuelRepository.save(new FuelEntity(new FuelProviderModel(ROMPETROL.getName(), LocalDate.now(), fuelModelList)));
//    }
//
//    @Override
//    public void close() {
//        driver.close();
//    }
//}
