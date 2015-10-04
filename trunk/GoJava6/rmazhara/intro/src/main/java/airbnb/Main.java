package airbnb;

import java.util.HashSet;

/**
 * Created by mazha on 10/1/2015.
 */
public class Main {
    public static void main(String[] args) throws MyException {
        Menu menu = new Menu();
        for(int i =0; i<10; i++) {
            menu.startMenu();
            for (Host hostSet : menu.hostSet) {
                System.out.println(hostSet.getName());
                System.out.println(hostSet.getSurname());
                System.out.println(hostSet.getEmail());
            }
        }
    }
}
