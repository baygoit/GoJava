package goit.iavorskyi;

import java.util.Scanner;

public class Autorizer {
 
        Scanner in = new Scanner(System.in);
        private String login = null;
        private String password = null;
        private String repeatPassword = null;
        private String choise = "";
 
        public void autorize() {
                System.out.println("1. Login. \n2. Register.");
                choise = in.next();
 
                if (choise.equals("1")) {
                        login();
                } else if (choise.equals("2")) {
                        register();
                } else {
                        System.out.println("No such option.");
                }
        }
 
        private void login() {
                System.out.println("input login: ");
                login = in.next();
                System.out.println("input password: ");
                password = in.next();
 
                if (login.equals("user") && password.equals("pass")) {
                        System.out.println("You are logined");
                } else {
                        System.out.println("User or password incorrect");
                }
        }
 
        private void register() {
                System.out.println("input login: ");
                login = in.next();
                do {
                        System.out.println("input password: ");
                        password = in.next();
                        System.out.println("repeat password: ");
                        repeatPassword = in.next();
                        if (!password.equals(repeatPassword)) {
                                System.out.println("Passwords does not match. Repeat.");
                        }
                } while (!password.equals(repeatPassword));
                System.out.println("You are registered.");
        }
}