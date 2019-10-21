package be.springPressOrder;
import be.springPressOrder.configuration.RepositoryConfiguration;
import be.springPressOrder.dao.PressOrderRepository;
import be.springPressOrder.domain.Fruit;
import be.springPressOrder.domain.Juice;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BVAenEPTest {
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
