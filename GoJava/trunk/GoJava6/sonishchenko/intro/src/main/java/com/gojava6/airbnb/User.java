package com.gojava6.airbnb;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sergio on 18-Sep-15.
 */
public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String repeatPassword;

    List<String> users = new ArrayList<String>();



//    public void registerUser() {
//        Scanner inputTest = new Scanner(System.in);
//        String input = inputTest.nextLine();
//        System.out.println("Please enter you Name:");
//
//        if (name.length() < 2) {
//            System.out.println("Name must be longer then 2 symbols");
//        } else {
//            this.name = input;
//        }
//
//        System.out.println("Please enter you Surname");
//
//        if (surname.length() < 2) {
//            System.out.println("Surname must be longer then 2 symbols");
//        } else {
//            this.surname = input;
//        }
//
//        System.out.println("E-mail:");
//
//        if (email.contains("@")) {
//            this.email = input;
//        } else {
//            System.out.println("Please enter correct E-mail");
//        }
//
//        System.out.println("Please enter your password:");
//        if (surname.length() < 5) {
//            System.out.println("password must be longer then 5 symbols");
//        } else {
//            this.password = input;
//        }
//        System.out.println("Please repeat you password:");
//        this.repeatPassword = input;
//        if (this.password == this.repeatPassword) {
//        } else {
//            System.out.println("Password not equal");
//        }
//
//
//    }


}
