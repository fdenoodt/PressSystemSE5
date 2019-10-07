package be.springPressOrder.domain;

import java.util.ArrayList;

public class Factory {
    private int id;
    private Address address;
    private ArrayList<Machine> machines;

    public Factory(int id, Address address) {
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}
