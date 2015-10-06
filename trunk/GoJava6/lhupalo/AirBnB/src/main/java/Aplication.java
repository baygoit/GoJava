/**
 * Created by Ыўср on 23.09.2015.
 */
public class Aplication  {
    public static void main(String[] args) {
        // First block - Observer/LoayaltyProgram

        LoayaltyProgram loayaltyProgram = new LoayaltyProgram();

        Client client11 = new Client("Yan", "Serfo", "erf@gg.com");
        Client client21 = new Client("Tim", "Tornvald", "tim@bbol.com");
        Client client31 = new Client("Timotey", "Wordes", "tW0rd@bbol.com");

        Observer client1 = client11;
        Observer client2 = client21;
        Observer client3 = client31;

        loayaltyProgram.register(client1);
        loayaltyProgram.register(client2);
        loayaltyProgram.register(client3);
        loayaltyProgram.notifyAllObservers();

//Second block - Booking

        Host host1 = new Host("Jon", "Tuvon", "jon@tyr.com");
        Host host2 = new Host("Jak", "Citron", "citron@tyr.com");
        Host host3 = new Host("Mikael", "Giden", "giden@tyr.com");
        Apartment apartment1 = new Apartment("London", ApartmentType.ROOM, host1 );
        Apartment apartment2 = new Apartment("London", ApartmentType.APARTMENT, host1 );
        Apartment apartment3 = new Apartment("Paris", ApartmentType.PLACE, host2 );
        Apartment apartment4 = new Apartment("Paris", ApartmentType.ROOM, host2 );
        Apartment apartment5 = new Apartment("Berlin", ApartmentType.APARTMENT, host3 );
        Apartment apartment6 = new Apartment("Berlin", ApartmentType.ROOM, host3 );
        Apartment apartment7 = new Apartment("Berlin", ApartmentType.PLACE, host3 );

    }
}