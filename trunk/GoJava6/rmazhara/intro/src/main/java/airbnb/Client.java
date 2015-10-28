package airbnb;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by mazha on 9/29/2015.
 */
public class Client extends User implements Observer {

    public void update(Observable o, Object arg) {

    }

    @Override
    public void registerNew(Scanner scanner) throws MyException {
        System.out.println("Please enter your name:");
        this.setName(scanner.next());
        System.out.println("Please enter your surname:");
        this.setSurname(scanner.next());
        System.out.println("Please enter your email:");
        this.setEmail(scanner.next());
    }
}
