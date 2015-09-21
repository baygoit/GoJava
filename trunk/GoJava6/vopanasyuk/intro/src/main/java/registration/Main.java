package registration;

/**
 * Created by oktopus on 21.09.15.
 */
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        System.out.println("Create two Client and Host");
        Client client1 = new Client();
        Client client2 = new Client();
        client1.setUserName("Vasya");
        client1.setUserSurname("Griwun");
        client1.setUserEmail("Vasya@griwun.com");

        client2.setUserName("Petr");
        client2.setUserSurname("Okunov");
        client2.setUserEmail("Petr@okunov.com");

        Host host = new Host();
        host.setUserName("lol");
        host.setUserSurname("kak");
        host.setUserEmail("lol@kak.com");
        host.setApartmentType(app.getTypeRoom());
        host.setCity("Astrahan");

        Validation validation = new Validation();

        //Registration of 1 host and 2 clients
        app.registerUser(host);
        app.registerUser(client1);
        app.registerUser(client2);

        //Two clients signed for loyalty program notification
        validation.register(client1);
        validation.register(client2);
        validation.setAvailable(true);

        //1 of 2 clients decided that he or she doesn't want to receive notifications
        validation.remove(client1);
        validation.setAvailable(true);

    }
}
