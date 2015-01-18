package ua.lslayer.hackit;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import ua.lslayer.hackit.dao.UserAccountDAO;

public class MainGameLoop 
{
    public static void main( String[] args ) throws JAXBException, FileNotFoundException
    {
//        __Assistant assistant = new __Assistant();
//        UserAccount myUnneedenAccount = assistant.makeMeAnAccountFilledWithAllINeed();
//        UserAccount myAccount = UserAccountDAO.create("accname", "password");
        UserAccount myAccount = UserAccountDAO.read("accname", "password");
//        myAccount.setHero(myUnneedenAccount.getHero());
//        UserAccountDAO.save(myAccount);
//        String login = null;
//        String pass = null;
        while (true) {
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
//        	myAccount.login("accname", "masterkey");
            Hero currentHero = myAccount.getHero();
            System.out.println("Welcome " + currentHero.getName());
            System.out.println(currentHero.listSkills());
            //Here comes some funny stuff, which will make some changes to currnetHero
//            myAccount.setHero(currentHero);
//            myAccount.logOut();
            System.exit(0);
        }
//    	GameConsole gameConsole = new GameConsole();
//    	while (true) gameConsole.runNextCommand();
    }
}
