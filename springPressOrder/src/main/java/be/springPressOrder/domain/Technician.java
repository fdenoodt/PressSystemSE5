package be.springPressOrder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "technicians")
public class Technician extends User{

    @Column
    private Boolean isAvaileble;

    @OneToMany(mappedBy = "technician")
    private List<RequestTechnician> requestTechnicians = new ArrayList<>();


    public Technician(String name, String firstname, String phone, String email, String username,String role, String password) {
        super(name, firstname, phone, email,username,role,password);
    }

    public Technician(){}

    public Boolean getAvaileble() {
        return isAvaileble;
    }

    public void setAvaileble(Boolean availeble) {
        isAvaileble = availeble;
    }

    public List<RequestTechnician> getRequestTechnicians(){
        return requestTechnicians;
    }
}
