package be.springPressOrder.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "USERS")
@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotEmpty(message="Username can not be empty.")
    private String username;

    @Column
    @NotEmpty(message="Name can not be empty.")
    private String name;

    @Column
    private String firstname;

    // Must be {bcrypt}-encoded
    @Column
    private String password;

    @Column
    private String phone;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    @Column
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$",message="Insert a valid email")
    private String email;
    //private Address address;

    //Will be declared in subclass
    @Column
    private String role;

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword(){return password;}

    public Set<Order> getOrders(){
        return orders;
    }

    public void setPassword(String password) {
        this.password = "{noop}"+password;
    }

    public User(String name, String firstname, String phone, String email, String username, String role, String password) {
        this.name = name;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.role = role;
        this.password = password;
        this.orders = new HashSet<>();
    }

    public User(){
        this.role = "ROL_USER";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
