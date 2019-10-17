package be.springPressOrder.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DttQuantityJuice {

    @Test
    //aantal fruit = 10
    public void tc1() {
        Fruit fruit = new Fruit("Peer");
        try {
            Juice juice = new Juice(fruit,-10, new Date(),10,100, 4);
        }
        catch (Exception e) {
            System.out.println((e));
        }
    }

    @Test
    // aantal fruit = 10
    //type say = appel
    // max aantal = 20
    public void tc2() {
        Fruit fruit = new Fruit("Appel");
        try {
            Juice juice = new Juice(fruit,20, new Date(),10,100, 4);
        }
        catch (Exception e) {
            System.out.println((e));
        }
    }

    @Test
    // aantal fruit = 10
    //type say = geen
    // max aantal = 20
    public void tc3() {
        Fruit fruit = new Fruit("None");
        try {
            Juice juice = new Juice(fruit,10, new Date(),10,20, 4);
        }
        catch (Exception e) {
            System.out.println((e));
        }
    }

    @Test
    // aantal fruit = 10
    //type say = appel
    // max aantal = -20
    public void tc4() {
        Fruit fruit = new Fruit("Appel");
        try {
            Juice juice = new Juice(fruit,10, new Date(),10,-20, 4);
        }
        catch (Exception e) {
            System.out.println((e));
        }
    }

    @Test
    // aantal fruit = 10
    //type say = geen
    // max aantal = -20
    public void tc5() {
        Fruit fruit = new Fruit("None");
        try {
            Juice juice = new Juice(fruit,10, new Date(),10,-20, 4);
        }
        catch (Exception e) {
            System.out.println((e));
        }
    }
}
