package be.springPressOrder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BVAEnEPTest {

    public static Juice juice;
    @BeforeAll
    public static void init() {
        Fruit fruit = new Fruit("Peer");
        try {
            juice = new Juice(fruit,8, new Date(),10,100, 4);
        }
        catch (Exception e) {
            System.out.println((e));
        }
    }
    @Test
    public void testBVA() {
        assertThrows(IllegalArgumentException.class,() -> juice.setAmount(3)); // BVA
        assertThrows(IllegalArgumentException.class,() -> juice.setAmount(101)); // BVA
    }

    @Test
    public void  testEP() {
        try {
            juice.setAmount(50);
            assertEquals(50, juice.getAmount()); // EP
        }  catch (Exception e) {
            System.out.println((e));
        }
    }


}
