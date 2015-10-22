import model.CityList;
import model.GenderType;
import model.User;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SerializationIOTest {

    //private static final Logger fLogger = Logger.getLogger(io.airbnbIOTests.class.getPackage().getName());
    private User user1 =  user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(11011999), "jr@gmail.com", CityList.MIAMI);


    public void verifyWriteUsersToFileSerializable() {
        List<User> users = Arrays.asList(user1);
        System.out.println(users.toString());

        //serialize the List
        try (
                OutputStream file = new FileOutputStream("src/usersSerializable.ser");
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ) {
            output.writeObject(users);
        } catch (IOException ex) {
            //fLogger.log(Level.SEVERE, "Cannot perform output.", ex);
            System.out.println("Cannot perform output" + ex);
        }

    }


}
