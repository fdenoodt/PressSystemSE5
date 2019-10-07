package be.springPressOrder.domain;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String town;

    @Column(nullable = false)
    private String country;

    public Address(String street, String number, String postalCode, String town, String country) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
    }

    public Address(){}

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }
}
