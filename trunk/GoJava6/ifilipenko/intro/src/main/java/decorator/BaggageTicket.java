package decorator;

public class BaggageTicket extends BasicTicket {
    private BasicTicket ticket;

    public BaggageTicket(BasicTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int price() {
        return ticket.price() + 5;
    }
}
