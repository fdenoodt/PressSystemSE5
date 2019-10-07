package be.springPressOrder.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_technician")
public class RequestTechnician {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date request_time;

    @Column
    private String message;

    @ManyToOne
    @JoinColumn
    private Technician technician;

    public RequestTechnician(){}

    public RequestTechnician(Date request_time, String message, Technician technician) {
        this.request_time = request_time;
        this.message = message;
        this.technician = technician;
    }

    public Integer getId() {
        return id;
    }

    public Date getRequest_time() {
        return request_time;
    }

    public String getMessage() {
        return message;
    }

    public Technician getTechnician() {
        return technician;
    }
}
