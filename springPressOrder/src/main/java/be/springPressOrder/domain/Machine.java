package be.springPressOrder.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Integer getId() {
        return id;
    }

    public enum Status {Ok, Not_OK}

    public Status getStatus() {
        return status;
    }

    public int getMaxCapacityPerHour() {
        return maxCapacityPerHour;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void changeStatus() {
        status = status == Status.Ok ? Status.Not_OK : Status.Ok;
    }

    private Status status;
    private boolean isOccupied;
    private int maxCapacityPerHour;

    @OneToMany(mappedBy = "machine")
    private Set<Rapport> reportList;

    @OneToMany(mappedBy = "machine")
    private Set<Schedule> schedules;

    public Machine(int id, boolean isOccupied, int maxCapacityPerHour) {
        this.id = id;
        this.isOccupied = isOccupied;
        this.maxCapacityPerHour = maxCapacityPerHour;
        reportList = new HashSet<>();
        schedules = new HashSet<>();
        status = Status.Ok;
    }

    public Machine() {
        reportList = new HashSet<>();
        schedules = new HashSet<>();

        changeStatus();
    }


    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int maxCapacityPerHour() {
        return maxCapacityPerHour;
    }

    public void setMaxCapacityPerHour(int maxCapacityPerHour) {
        this.maxCapacityPerHour = maxCapacityPerHour;
    }

    public Set<Rapport> getReportList() {
        return reportList;
    }

    public void addRapport(Rapport rapport) {
        reportList.add(rapport);
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

}
