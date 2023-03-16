package co.develhope.First_API_05.DTO;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
@Data
@ToString
public class CarDTO {
    @NotBlank(message = "Mandatory")
    private String id;
    @NotBlank(message = "Mandatory")
    private String modelName;
    @NotBlank(message = "Mandatory")
    private double price;

}
