package be.springPressOrder.domain;

public class Presser extends Person {
    public Presser(String name, String firstname, String phone, String email, String username,String password) {
        super(name, firstname, phone, email,username,"presser",password);
    }
    public Presser(){
        super("presser");
    }
}
