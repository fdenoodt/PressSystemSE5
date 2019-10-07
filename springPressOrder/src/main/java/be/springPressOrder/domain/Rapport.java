package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rapports")
public class Rapport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private Machine.Status previousStatus;
    private Machine.Status newStatus;
    private String log;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date checkTime;

    public Rapport(Machine machine, Machine.Status previousStatus, Machine.Status newStatus, String log) {
        this.checkTime = new Date();
        this.machine = machine;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.log = log;
    }

    public Rapport(){}

    public int getId() {
        return id;
    }

    public Machine.Status getPreviousStatus() {
        return previousStatus;
    }

    public Machine.Status getNewStatus() {
        return newStatus;
    }

    public String getLog() {
        return log;
    }
}
