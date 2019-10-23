package be.springPressOrder.domain;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class SceduleTest {

    private PressOrder order;
    private Machine machine;

    @Before
    public void prepareTests() {

        this.order = new PressOrder(2,3,new Order());
        this.machine = new Machine(1,false,2);
    }

    @Test
    //Machine is null
    public void setMachineAanNull(){
        new Schedule(null,order,new Date(),new Date());
    }

    @Test
    //PressOrder is null
    public void setPressOrderAanNull(){
        new Schedule(machine,null,new Date(),new Date());
    }

    @Test
    //StartHour is null
    public void setStartHourAanNull(){
        new Schedule(machine,order,null,new Date());
    }

    @Test
    //EndHour is null
    public void setEndHourAanNull(){
        new Schedule(machine,order,new Date(),null);
    }


}
