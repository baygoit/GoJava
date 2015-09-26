package ticket;

/**
 * Created by oktopus on 21.09.15.
 */
public class InternetTicketSaling {

    public static void main(String[] args) {
        BasicTicket basicTicket = new FoodTicket(new BasicTicket());
        basicTicket = new PlaceTicket(basicTicket);
        basicTicket = new BuggageTicket(basicTicket);
        System.out.println(basicTicket.price());{
        }
    }
}
