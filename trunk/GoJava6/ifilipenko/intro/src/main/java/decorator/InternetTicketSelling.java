package decorator;

public class InternetTicketSelling {

    public static void main(String[] args) {
        BasicTicket basicTicket = new BasicTicket();
        BasicTicket foodTicket = new FoodTicket(new BasicTicket());
        BasicTicket placeTicket = new PlaceTicket(basicTicket);
        BasicTicket baggageTicket = new BaggageTicket(basicTicket);
        System.out.println(baggageTicket.price());
    }
}
