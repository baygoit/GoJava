package airbnb;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mazha on 9/29/2015.
 */
public class Menu {
    Set<Host> hostSet = new HashSet<Host>();
    Set<Client> clientSet = new HashSet<Client>();

    public void startMenu() throws MyException {
        Scanner scanner = new Scanner(System.in);
        this.registrationMenu();
        if (scanner.next().equals("1")) {
            userRegistration(scanner);
            userRegistration(scanner);
        }

    }

    public void registrationMenu() {
          System.out.println("1.Register new user");
    }

    public void userRegistration(Scanner scanner) throws MyException {
        System.out.println("1.Register new client");
        System.out.println("2.Register new host");
        String checker = scanner.next();
        if (checker.equals("1")) {
            Client client = new Client();
            client.registerNew(scanner);
            clientSet.add(client);
            return;
        } else if (checker.equals("2")) {
            Host host = new Host();
            host.registerNew(scanner);
            hostSet.add(host);
            return;
        }
    }


}
