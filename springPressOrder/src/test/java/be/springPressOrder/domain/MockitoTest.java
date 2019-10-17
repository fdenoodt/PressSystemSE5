package be.springPressOrder.domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;



public class MockitoTest {
    @Mock
    IMockitoService iMockitoService;

    public static int validQuantityMinMax() {
        return and(gt(0), lt(100));
    }

    public static Fruit validFruit() {
        Fruit fruit = new Fruit("peer");
        return fruit;
    }

    @BeforeEach
    void setUp() {
        initMocks(this);

        

    }



}
