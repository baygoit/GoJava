package io;

import dao.Dao;
import dao.io.HomeIODao;
import model.GenderType;
import model.Home;
import model.HomeType;
import model.User;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class homeIOTest {

    @Test
    public void verifyWriteUsersToFile() throws IOException {

        File expected = new File(this.getClass().getResource("/testhome").getFile());
        File actual = new File(this.getClass().getResource("/home").getFile());

        User user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(11011999), "jr@gmail.com", "Miami");
        Home home1 = new Home(user1, "Miami", HomeType.APARTMENT);
        List<Home> homeList = new ArrayList<>();
        homeList.add(home1);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(expected))
        ){
            for (Home home : homeList) {
                writer.write(home.getHost() + " | ");
                writer.write(home.getCity() + " | ");
                writer.write(home.getHomeType() + "\n");
            }
        }
        catch(IOException ex){
            System.out.println("Cannot perform output" + ex);
        }

        Dao oiDao = new HomeIODao();
        oiDao.createAll(actual);

        Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(actual));
    }

}
