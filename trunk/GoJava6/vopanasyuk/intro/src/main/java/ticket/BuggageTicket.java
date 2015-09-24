package ticket;

/**
 * Created by oktopus on 21.09.15.
 */
public class BuggageTicket extends BasicTicket {
    private BasicTicket ticket;

    public BuggageTicket(BasicTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int price() {
        return ticket.price() + 20;
    }
}
