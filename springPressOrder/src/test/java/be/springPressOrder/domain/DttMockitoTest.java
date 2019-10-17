package be.springPressOrder.domain;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;


public class DttMockitoTest {

    @Test
    public void Test1() {
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void Test2() {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

        // the following prints "first"
        System.out.println(mockedList.get(0));

        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    @Mock
    DttCheckService dttCheckService;

    public static int ticketNoValidRange() {
        return and(gt(123455), lt(123459));
    }

    public static int juisteKlantno(){
        return eq(1234);
    }

    @BeforeEach
    void setUp() {
        initMocks(this);

        Mockito.when(dttCheckService.checkTicketExistence(ticketNoValidRange()))
                .thenReturn(true);
        Mockito.when(dttCheckService.checkTicketExistence(not(ticketNoValidRange())))
                .thenReturn(false);

        Mockito.when(dttCheckService.checkTicket(not(ticketNoValidRange()), anyInt()))
                .thenReturn("Onbenkend ticketnummer");

        Mockito.when(dttCheckService.checkTicket(not(ticketNoValidRange()), not(juisteKlantno())))
                .thenReturn("Probeer opnieuw")
                .thenReturn("Probeer opnieuw")
                .thenReturn("Ticket nummer werd geblokeerd");

        Mockito.when(dttCheckService.checkTicket(not(ticketNoValidRange()), juisteKlantno()))
                .thenReturn("Ga verder met reservatie")
                .thenReturn("Er werd al een ticket gereserveerd");
    }

    @Test
    void Test10 () {
        assertEquals("Onbenkend ticketnummer", dttCheckService.checkTicket(123459, 2468));
    }

    @Test
    void Test11 () {
        assertEquals("Probeer opnieuw", dttCheckService.checkTicket(123456, 2468));
        assertEquals("Probeer opnieuw", dttCheckService.checkTicket(123456, 2469));
    }

    @Test
    void Test12 () {
        assertEquals("Ga verder met reservatie", dttCheckService.checkTicket(123458, 1234));
    }

}
