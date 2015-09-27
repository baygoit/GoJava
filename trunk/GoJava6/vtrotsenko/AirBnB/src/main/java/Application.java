import com.airbnb.apartment.*;
import com.airbnb.observer.*;
import com.airbnb.system.*;
import com.airbnb.user.*;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by root on 19.09.15.
 */
public class Application {

    public static void main(String args[]) {

        AirBnBSystem airSys = new AirBnBSystem();

        Client client1 = new Client("Vlad", "Trotsenko", "v.t@gmail.com");
        Client client2 = new Client("Tanya", "Odynets", "TOdynets@gmail.com");
        Client client3 = new Client("Dennis", "Petrenko", "dpetrenko@gmail.com");
        airSys.registerClient(client1);
        airSys.registerClient(client2);
        airSys.registerClient(client3);

        // here must be fail registration
        Host host1 = new Host("Illya", "Litvin", "litvin@gmail.com", "Kyiv", LocalDate.of(2015, Month.SEPTEMBER, 10),
                LocalDate.of(2015, Month.SEPTEMBER, 9), ApartmentType.ROOM);

        Host host2 = new Host("Kirill", "Vaschen", "kirya@gmail.com", "Lviv", LocalDate.of(2015, Month.SEPTEMBER, 29),
                LocalDate.of(2015, Month.OCTOBER, 3), ApartmentType.APARTMENT);

        Host host3 = new Host("Artem", "Nikolaev", "arnik@gmail.com", "Kyiv", LocalDate.of(2015, Month.OCTOBER, 7),
                LocalDate.of(2015, Month.OCTOBER, 17), ApartmentType.PLACE);

        airSys.registerHost(host1);
        airSys.registerHost(host2);
        airSys.registerHost(host3);

        Client client4 = new Client("George", "Katuasvil", "george1@gmail.com");
        airSys.registerClient(client4);

        System.out.println("List of cities: ");
        for(String tempCity : airSys.getListofCities()) {
            System.out.println(tempCity);
        }

        System.out.println("List of observers: ");
        for(Observer n : airSys.getListOfObservers()) {
            System.out.println(n.getName());
        }

        System.out.println("List of available Hosts: ");
        for (Observer observer : airSys.getListOfObservers()) {
            if (observer.getClass().equals(host1.getClass())) {
                Host host = (Host) observer;
                if (host.getApartment().isAvailable()) {
                    System.out.println("---" + host.getName() + " date: " + host.getApartment().getFirstDayAvailable() +
                            " - " + host.getApartment().getLastDayAvailable());
                }
            }
        }
        airSys.makeReservation(client2, host2, LocalDate.of(2015, Month.SEPTEMBER, 30),
                LocalDate.of(2015, Month.OCTOBER, 2));

        System.out.println("List of available Hosts: ");
        for (Observer observer : airSys.getListOfObservers()) {
            if (observer.getClass().equals(host1.getClass())) {
                Host host = (Host) observer;
                if (host.getApartment().isAvailable()) {
                    System.out.println("---" + host.getName() + " date: " + host.getApartment().getFirstDayAvailable() +
                            " - " + host.getApartment().getLastDayAvailable());
                }
            }
        }


        airSys.makeReservation(client1, host2, LocalDate.of(2015, Month.SEPTEMBER, 29),
                LocalDate.of(2015, Month.SEPTEMBER, 30));

        System.out.println("List of available Hosts: ");
        for (Observer observer : airSys.getListOfObservers()) {
            if (observer.getClass().equals(host1.getClass())) {
                Host host = (Host) observer;
                if (host.getApartment().isAvailable()) {
                    System.out.println("---" + host.getName() + " date: " + host.getApartment().getFirstDayAvailable() +
                            " - " + host.getApartment().getLastDayAvailable());
                }
            }
        }
    }

}
