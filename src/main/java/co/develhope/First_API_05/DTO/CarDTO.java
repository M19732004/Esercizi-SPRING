package co.develhope.First_API_05.DTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.constraints.NotBlank;
@Data

public class CarDTO {
    @NotBlank(message = "Mandatory")
    private long id;
    @NotBlank(message = "Mandatory")
    private String modelName;
    @NotBlank(message = "Mandatory")
    private Double price;


    public CarDTO(){

    }

    public CarDTO(long id, String modelName, double price) {
        this.id = id;
        this.modelName = modelName;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d",id,modelName,price);
    }
}
