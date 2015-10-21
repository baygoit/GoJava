import model.*;

import java.util.Date;

public class Airbnb {

    public static void main(String[] args) {

        User user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(11011999), "jr@gmail.com", CityList.MIAMI);
        User user2 = new User(2, "Bridget", "Raabe", GenderType.FEMALE, new Date(12011999), "br@gmail.com", CityList.NEW_YORK);

        Home home1 = new Home(CityList.MIAMI, HomeType.APARTMENT);


    }
}
