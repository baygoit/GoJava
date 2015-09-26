package airbnb;

/**
 * Created by slavik on 21.09.2015.
 */

public class App {
    public static void main(String[] args) {
        Base base = new Base();
        User user = new Host("Name", "Surname", "email@site.com", "Kiev", RentType.ROOM);
        base.add(user);
        user =  new Host("NameOne", "SurnameOne", "emailOne@site.com", "Kiev", RentType.PLACE);
        base.add(user);
        user =  new Client("NameTwo", "SurnameTwo", "emailTwo@site.com");
        base.add(user);
        user =  new Client("NameThree", "SurnameThree", "emailThree@site.com");
        base.add(user);
        base.notifyAll("ready");
       // base.remove("SurnameTwo");
        base.notifyAll("minus one");
    }
}
