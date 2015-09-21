package registration;

/**
 * Created by oktopus on 21.09.15.
 */
public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        System.out.println("Create two Client and Host");
        Observer client1 = new Client();
        Observer client2 = new Client();
        validation.register(client1);
        validation.register(client2);

        Observer host = new Host();
        validation.register(host);
        validation.notifyObservers();
        System.out.println("Delete one client");
        System.out.println("Show who stayed");
        validation.remove(client2);

        validation.notifyObservers();

    }
}
