package com.decorator;

/**
 * Created by sergiigetman on 9/21/15.
 */
public class FoodTicket extends BacisTicket{
    private BacisTicket ticket;

    public FoodTicket(BacisTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int price() {
        return ticket.price() + 20;
    }
}
