package ie.atu.vehiclemanagement;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "vehicle")
public class Vehicle {

    @Id @Pattern(regexp = "^[A-Z]{2}[0-9]{4}$")
    private String registrationNumber;
    @NotEmpty(message = "Vehicle name must not be empty")
    private String vehicleName;
    @NotEmpty(message = "Vehicle Type must not be empty")
    private String vehicleType;
    @Positive(message = "Vehicle must be valued at more than 0")
    private float price;
    @Range(min = 1886, max = 2024, message = "Vehicle must be valid year between 1886-2024")
    private int yearOfManufacture;
    @PositiveOrZero(message = "Mileage must be 0 or more")
    private int mileage;

}
