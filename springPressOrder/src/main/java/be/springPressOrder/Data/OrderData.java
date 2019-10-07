package be.springPressOrder.Data;

import be.springPressOrder.domain.Status;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

@Data
public class OrderData {

    public Integer id = 0;

    @NotNull(message = "Fruit amount cannot be empty")
    public Integer amount;

    @NotNull(message = "Fruit amount cannot be empty")
    public Integer fruitId;

    public Integer userId;

    public Status statusOrder;

}
