package Practice.decorator;

/**
 * Created by sergiigetman on 9/21/15.
 */
public class PlaceTicket extends BacisTicket {
    private BacisTicket ticket;

    @Override
    public int price() {
        return ticket.price() + 10;
    }

    public PlaceTicket(BacisTicket ticket) {
        this.ticket = ticket;
    }
}
