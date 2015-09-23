package decorator;

public class InternetTicketSelling {

    public static void main(String[] args) {
        BasicTicket basicTicket = new FoodTicket(new BasicTicket());
        basicTicket = new PlaceTicket(basicTicket);
        basicTicket = new BaggageTicket(basicTicket);
        System.out.println(basicTicket.price());
    }
}
