package polymorphism;

public class FoodTicket extends StandardTicket{

    Ticket ticket = new StandardTicket();

    @Override
    public int price() {
         return ticket.price() + 10;
    }
}
