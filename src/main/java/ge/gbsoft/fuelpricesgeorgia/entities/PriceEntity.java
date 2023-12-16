package ge.gbsoft.fuelpricesgeorgia.entities;

import ge.gbsoft.fuelpricesgeorgia.dto.PriceDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "price")
public class PriceEntity {
    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FuelEntity fuel;

    @Column(name = "price")
    private double price;

    @Column(name = "date")
    private LocalDate date;

    public PriceEntity(FuelEntity fuel, PriceDto priceDto) {
        this.fuel = fuel;
        this.price = priceDto.getPrice();
        this.date = priceDto.getDate();
    }
}
