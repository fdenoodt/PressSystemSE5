package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class ScheduleData {

    public Integer id = 0;

    @NotNull(message = "Machine cannot be blank")
    public Integer machineId;

    @NotNull(message = "Press order cannot be blank")
    public Integer pressOrderId;

    @NotBlank(message = "Begin hour cannot be blank")
    @Pattern(regexp = "^[0-9]{4}[-][0-9]{2}[-][0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}")
    public String beginHour;

    @NotBlank(message = "End hour cannot be blank")
    @Pattern(regexp = "^[0-9]{4}[-][0-9]{2}[-][0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}")
    public String endHour;

}
