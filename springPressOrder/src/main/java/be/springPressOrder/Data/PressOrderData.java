package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class PressOrderData {

    public Integer id = 0;

    @NotNull(message = "Amount of fruit cannot be empty")
    public Integer fruitAmount;

    @NotNull(message = "Fruit cannot be empty")
    public Integer fruitId;

    public Integer userId;

    public Integer maxJuiceAmount;
}
