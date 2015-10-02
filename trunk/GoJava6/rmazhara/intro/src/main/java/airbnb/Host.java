package airbnb;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mazha on 9/29/2015.
 */
public class Host extends User {
    private Set<Apartment> hostsRooms = new HashSet<Apartment>();


    @Override
    public void registerNew(Scanner scanner) throws MyException {

        System.out.println("Please enter your name:");
        this.setName(scanner.next());
        System.out.println("Please enter your surname:");
        this.setSurname(scanner.next());
        System.out.println("Please enter your email:");
        this.setEmail(scanner.next());
        System.out.println("Do you want to register new apartment? y/n");
        String checker = scanner.next();
        if (checker.equals("y")) {
            System.out.println("Enter an address");
            registerNewApartment(scanner);

        }else if (checker.equals("n")){
            return;
        }

    }

    public void registerNewApartment(Scanner scanner) {
        Apartment apartment = new Apartment(scanner);
        hostsRooms.add(apartment);
    }
}
