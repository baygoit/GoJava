package decorator;

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
