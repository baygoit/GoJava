package ua.lslayer.hackit;

import java.util.Scanner;

public class MainGameLoop 
{
    public static void main( String[] args )
    {
//        __Assistant assistant = new __Assistant();
//        UserAccount myAccount = assistant.makeMeAnAccountFilledWithAllINeed();
//        String login = null;
//        String pass = null;
//        while (true) {
//            while (!myAccount.loggedIn()) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("Login:");
//                login = scanner.nextLine();
//                System.out.println("Password");
//                pass = scanner.nextLine();
//                scanner.close();
//                System.out.println(myAccount.login(login, pass) ?
//                            "Welcome " + myAccount.getHero().getName() + "!": //I know it's wrong.
//                            "Access Denied!");
//            }
//            Hero currentHero = myAccount.getHero();
//            System.out.println(currentHero.listSkills());
//            //Here comes some funny stuff, which will make some changes to currnetHero
//            myAccount.setHero(currentHero);
//            myAccount.logOut();
//            System.exit(0);
//        }
    	GameConsole gameConsole = new GameConsole();
    	while (true) gameConsole.runNextCommand();
    }
}
