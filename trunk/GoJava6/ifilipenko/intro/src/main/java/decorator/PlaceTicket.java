package decorator;


public class PlaceTicket extends BasicTicket {
    private BasicTicket ticket;

    @Override
    public int price() {
        return ticket.price() + 10;
    }

    public PlaceTicket(BasicTicket ticket) {
        this.ticket = ticket;
    }
}
