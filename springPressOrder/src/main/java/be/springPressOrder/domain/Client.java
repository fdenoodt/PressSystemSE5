package be.springPressOrder.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

public class Client extends Person {
    public Client(String name, String firstname, String phone, String email, String username, String password) {
        super(name, firstname, phone, email,username,"ROLE_USER",password);
    }



    public Client(){
        super("client");
    }
}
