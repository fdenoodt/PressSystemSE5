package be.springPressOrder.domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.apache.xpath.operations.Equals;
import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;


public class PressOrderCheckServiceTest {

    @Mock
    PressOrderCheckService pressOrderService;

    public static String validFruitTypes() {
        return or(eq("peer"), eq("appel"));
    }

    public static String appel() {
        return eq( "appel");
    }

    public static String peer() {
        return eq( "peer");
    }

    public static int minimumAantalPeren() {
        return gt(3);
    }

    public static int minimumAantalAppelen() {
        return gt(2);
    }

    @Before
    public void setUp() {
        initMocks(this);

        Mockito.when(pressOrderService.checkFruit(validFruitTypes())).thenReturn(true);

        Mockito.when(pressOrderService.checkFruit(not(validFruitTypes()))).thenReturn(false);

        Mockito.when(pressOrderService.checkFruitAmount(peer(), minimumAantalPeren()))
                .thenReturn("Order is geplaatst.");

        Mockito.when(pressOrderService.checkFruitAmount(appel(), minimumAantalAppelen()))
                .thenReturn("Order is geplaatst.");

        Mockito.when(pressOrderService.checkFruitAmount(peer(), not(minimumAantalPeren())))
                .thenReturn("Minimum aantal peren is 4 stuks.");

        Mockito.when(pressOrderService.checkFruitAmount(appel(), not(minimumAantalAppelen())))
                .thenReturn("Minimum aantal appels is 3 stuks.");

    }

    @Test
    // fruit = appel en aantal 5 -> order is geplaatst
    public void test1() {
        assertEquals("Order is geplaatst.", pressOrderService.checkFruitAmount("appel", 5));
    }

    @Test
    // fruit = peer en aantal 10 -> order is geplaatst
    public void test2() {
        assertEquals("Order is geplaatst.", pressOrderService.checkFruitAmount("peer", 10));
    }

    @Test
    // fruit = appel en aantal 2 -> Minimum aantal appels is 3 stuks
    public void test3() {
        assertEquals("Minimum aantal appels is 3 stuks.", pressOrderService.checkFruitAmount("appel", 2));
    }

    @Test
    // fruit = peer en aantal 2 -> Minimum aantal peren is 4 stuks
    public void test4() {
        assertEquals("Minimum aantal peren is 4 stuks.", pressOrderService.checkFruitAmount("peer", 2));
    }


}
