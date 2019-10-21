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
    public void testBVA1() {
        assertThrows(IllegalArgumentException.class,() -> juice.setAmount(4, 5, 100));
    }
    @Test
    public void testBVA2() {
        try {
            juice.setAmount(5, 5, 100);
            assertEquals(5, juice.getAmount());
            juice.setAmount(50, 5, 100);
            assertEquals(50, juice.getAmount());
        } catch (Exception e){
            System.out.println((e));
        }
    }
    @Test
    public void testBVA3() {
        try {
            juice.setAmount(51, 5, 100);
            assertEquals(52, juice.getAmount());
            juice.setAmount(100, 5, 100);
            assertEquals(101, juice.getAmount());
        } catch (Exception e){
            System.out.println((e));
        }
    }
    @Test
    public void testBVA4() {
        assertThrows(IllegalArgumentException.class,() -> juice.setAmount(101, 5, 100));
    }

    @Test
    public void  testEP1() {
        try {
            assertThrows(IllegalArgumentException.class,() -> juice.setAmount(-10, 5, 100));
        }  catch (Exception e) {
            System.out.println((e));
        }
    }
    @Test
    public void  testEP2() {
        try {
            juice.setAmount(20, 5, 100);
            assertEquals(20, juice.getAmount());
        }  catch (Exception e) {
            System.out.println((e));
        }
    }
    @Test
    public void  testEP3() {
        try {
            juice.setAmount(65, 5, 100);
            assertEquals(66, juice.getAmount());
        }  catch (Exception e) {
            System.out.println((e));
        }
    }
    @Test
    public void  testEP4() {
        try {
            assertThrows(IllegalArgumentException.class,() -> juice.setAmount(130, 5, 100));
        }  catch (Exception e) {
            System.out.println((e));
        }
    }

}
