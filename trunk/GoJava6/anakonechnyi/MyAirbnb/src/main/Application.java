package main;

import java.util.InputMismatchException;

/**
 * Created by user on 19.09.2015.
 */
public class Application {
    public void register (User user){
        System.out.println("Register");
    }

    public static void main(String[] args) {
        try {
            Host host = new Host("Tony", "Host", "booble@goom");
            host.setCity("Kyiv");
            host.setNewApartments("PLASE");
            /*switch (host.apartmentType.PLACE) {
                case PLACE:
                    host.switchedApartType="Place";
                    break;
                case ROOM:
                    host.switchedApartType="Room";
                    break;
                case APARTMENT:
                    host.switchedApartType="Apartment";
                    break;
            }*/
            Client client = new Client("Bony", "Client", "gooble@boom");
            host.registerObserver(client);
        } catch (InputMismatchException err) {
            System.out.println("Illegal name / sername / email");
        }

    }
}
