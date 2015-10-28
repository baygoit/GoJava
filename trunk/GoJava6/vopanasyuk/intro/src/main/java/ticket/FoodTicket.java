package ticket;

/**
 * Created by oktopus on 21.09.15.
 */
public class FoodTicket extends BasicTicket {
    private BasicTicket ticket;

    public FoodTicket(BasicTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int price() {
        return ticket.price() + 20;
    }

}
