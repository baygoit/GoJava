package com.gojava6.decorator;

/**
 * Created by sergiigetman on 9/21/15.
 */
public class InternetTicketSaling {

    public static void main(String[] args) {
        BacisTicket bacisTicket = new FoodTicket(new BacisTicket());
        bacisTicket = new PlaceTicket(bacisTicket);
        bacisTicket = new BaggageTicket(bacisTicket);
        System.out.println(bacisTicket.price());
    }
}
