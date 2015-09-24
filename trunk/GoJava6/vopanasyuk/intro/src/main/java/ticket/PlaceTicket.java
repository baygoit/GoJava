package ticket;

/**
 * Created by oktopus on 21.09.15.
 */
public class PlaceTicket extends BasicTicket {
    private BasicTicket ticket;

    public PlaceTicket(BasicTicket ticket) {
        this.ticket = ticket;
    }
    @Override
    public int price() {
        return ticket.price() + 10;
    }
}
