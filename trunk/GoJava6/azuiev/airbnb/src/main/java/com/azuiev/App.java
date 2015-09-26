package com.azuiev;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Organisation SportLife = new Organisation();

        User user1 = new Client("AA", "TT", "a@a.aa");
        Validator v = Validator.getInstance();
        if (!v.validateUser(user1)){
            System.out.println("Alarm1");
        }
        Host host1 = new Host("AA", "BB", "a@a.aa", "DD", ApartType.APARTAMENT);
        if (!v.validateUser(host1)){
            System.out.println("Alarm2");
        }
    }
}
