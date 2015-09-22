package com.azuiev;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Organisation SportLife = new Organisation();

        User user1 = new Client("AA", "2", "3");
        Validator v = Validator.getInstance();
        if (!v.validateUser(user1)){
            System.out.println("Alarm");
        }

    }
}
