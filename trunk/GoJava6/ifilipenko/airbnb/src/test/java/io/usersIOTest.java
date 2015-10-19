package io;

import dao.Dao;
import dao.io.UserIODao;
import model.GenderType;
import model.User;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class usersIOTest {
   //private static final Logger fLogger = Logger.getLogger(io.airbnbIOTests.class.getPackage().getName());

    private File expected;
    private File actual;

    @Before
    public void init(){
        expected = new File(this.getClass().getResource("/testusers").getFile());
        actual = new File(this.getClass().getResource("/users").getFile());
    }

    @Ignore
    @Test
    public void verifyWriteUsersToFileSerializable(){

        User user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(1012001), "jr@gmail.com", "Miami");
        List<User> users = Arrays.asList(user1);
        System.out.println(users.toString());

        //serialize the List
        try (
                OutputStream file = new FileOutputStream("src/usersSerializable.ser");
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ){
            output.writeObject(users);
        }
        catch(IOException ex){
            //fLogger.log(Level.SEVERE, "Cannot perform output.", ex);
            System.out.println("Cannot perform output" + ex);
        }

    }

    @Test
    public void verifyWriteUsersToFile() throws IOException {
        User user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(11011999), "jr@gmail.com", "Miami");
        User user2 = new User(2, "Bridget", "Raabe", GenderType.FEMALE, new Date(12011999), "br@gmail.com", "NY");
        List<User> users = Arrays.asList(user1, user2);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(expected))
        ){
            for (User user : users) {
                writer.write(user.getExternalCode()  + " | ");
                writer.write(user.getName() + " | ");
                writer.write(user.getLastName() + " | ");
                writer.write(user.getGender() + " | ");
                writer.write(user.getBirthDate() + " | ");
                writer.write(user.getEmail() + " | ");
                writer.write(user.getCity() + "\n");
            }
        }
        catch(IOException ex){
            System.out.println("Cannot perform output" + ex);
        }

        Dao oiDao = new UserIODao();
        oiDao.createAll(actual);

        Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(actual));
    }


}
