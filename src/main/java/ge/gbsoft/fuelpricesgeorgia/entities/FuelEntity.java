package ge.gbsoft.fuelpricesgeorgia.entities;

import ge.gbsoft.fuelpricesgeorgia.data.FuelProvider;
import ge.gbsoft.fuelpricesgeorgia.data.FuelType;
import ge.gbsoft.fuelpricesgeorgia.dto.FuelDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;



@Data
@NoArgsConstructor
@Entity
@Table(name = "fuel", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"provider", "type", "self_service"})
})
public class FuelEntity {
    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "provider")
    private FuelProvider fuelProvider;

    @Column(name = "type")
    private FuelType fuelType;

    @Column(name = "self_service")
    private Boolean selfService;

    public FuelEntity(FuelDto fuelDto) {
        this.fuelProvider = fuelDto.getProvider();
        this.fuelType = fuelDto.getType();
        this.selfService = fuelDto.isSelfService();
    }
}
