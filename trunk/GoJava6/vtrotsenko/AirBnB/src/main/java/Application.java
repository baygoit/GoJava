/**
 * Created by root on 19.09.15.
 */
public class Application {

    public static void main(String args[]) {

        /*User user1 = new User("Dennis", "Ivanov", "divanov@gmail.com");
        User user2 = new User("Sveta", "Shevchenko", "ssheva@ukr.net");

        AirBnBSystem sys = new AirBnBSystem();
        sys.registerObserver(user1);
        sys.registerObserver(user2);

        sys.notifyAllObservers();
        */

        AirBnBSystem airSys = new AirBnBSystem();

        Client client1 = new Client("Vlad", "Trotsenko", "v.t@gmail.com");
        Client client2 = new Client("Tanya", "Odynets", "TOdynets@gmail.com");
        Client client3 = new Client("Dennis", "Petrenko", "dpetrenko@gmail.com");
        airSys.registerClient(client1);
        airSys.registerClient(client2);
        airSys.registerClient(client3);

        Host host1 = new Host("Illya", "Litvin", "litvin@gmail.com", "Kyiv", ApartmentType.ROOM);
        airSys.registerHost(host1);

        Host host2 = new Host("Kirill", "Vascheikin", "kirya@gmail.com", "Lviv", ApartmentType.APARTMENT);
        airSys.registerHost(host2);

        Host host3 = new Host("Artem", "Nikolaev", "arnik@gmail.com", "Kyiv", ApartmentType.PLACE);
        airSys.registerHost(host3);

        Client client4 = new Client("George", "Katuasvil", "george1@gmail.com");
        airSys.registerClient(client4);

        System.out.println("--------------------------");
        System.out.println("List of cities: ");
        for(String tempCity : airSys.getListofCities()) {
            System.out.println(tempCity);
        }
        System.out.println("--------------------------");

        System.out.println("List of observers: ");
        for(Observer n : airSys.getListOfObservers()) {
            System.out.println(n.getName());
        }
        System.out.println("--------------------------");

        //Host host1 = new Host("Dan", "Vel", "dv@gmail.com", "Kiev", ApartmentType.ROOM);
        //airSys.registerHost(host1);


    }

}
