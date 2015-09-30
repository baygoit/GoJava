package com.gojava6.decorator;

/**
 * Created by sergiigetman on 9/21/15.
 */
public class BaggageTicket extends BacisTicket{
    private BacisTicket ticket;

    public BaggageTicket(BacisTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int price() {
        return ticket.price() + 5;
    }
}
