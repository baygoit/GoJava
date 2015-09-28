package polymorphism;

public class StandardTicket implements Ticket {

    @Override
    public int price() {
        return 5;
    }
}
