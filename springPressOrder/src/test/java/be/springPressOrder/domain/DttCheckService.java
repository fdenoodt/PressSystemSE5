package be.springPressOrder.domain;

public interface DttCheckService {
    public boolean checkTicketExistence(int ticketno);
    public String checkTicket(int ticketno, int klantno);
}
