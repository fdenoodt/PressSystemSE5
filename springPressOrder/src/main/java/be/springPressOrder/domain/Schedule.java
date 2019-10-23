package be.springPressOrder.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Schedules")
@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(force=true)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    @NotNull(message = "Machine cannot be null")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "pressOrder_id")
    @NotNull(message = "Pressorder cannot be null")
    private PressOrder pressOrder;

    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    @NotNull(message = "Starthour cannot be null")
    private Date startHour;

    @NotNull(message = "endhour cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date endHour;

    public Schedule() {
    }


    public Schedule(Machine machine, PressOrder pressOrder, Date startHour, Date endHour) {

        if(machine == null) throw new NullPointerException("Machine mag niet null zijn");
        this.machine = machine;

        if(pressOrder == null) throw new NullPointerException("Pressorder mag niet null zijn");
        this.pressOrder = pressOrder;

        if(startHour == null) throw new NullPointerException("startHour mag niet null zijn");
        this.startHour = startHour;

        if(endHour == null) throw new NullPointerException("endHour mag niet null zijn");
        this.endHour = endHour;
    }

    /**   public Integer getId() {
     return id;
     }

     public void setId(Integer id) {
     this.id = id;
     }

     public Machine getMachine() {
     return machine;
     }

     public void setMachine(Machine machine) {
     this.machine = machine;
     }

     public PressOrder getPressOrder() {
     return pressOrder;
     }

     public void setPressOrder(PressOrder pressOrder) {
     this.pressOrder = pressOrder;
     }

     public Date getStartHour() {
     return startHour;
     }

     public void setStartHour(Date startHour) {
     this.startHour = startHour;
     }

     public Date getEndHour() {
     return endHour;
     }

     public void setEndHour(Date endHour) {
     this.endHour = endHour;
     }**/
}
