package io;

import dao.io.MyUtil;
import model.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.HomeService;
import services.UserService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class usersIOTest {
    private User user1;
    private User user2;
    private Home home1;
    MyUtil util = new MyUtil();


    @Before
    public void init() {
        user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(11011999), "jr@gmail.com", CityList.MIAMI);
        user2 = new User(2, "Bridget", "Raabe", GenderType.FEMALE, new Date(12011999), "br@gmail.com", CityList.NEW_YORK);
        home1 = new Home(user1, CityList.MIAMI, HomeType.APARTMENT);
    }

    @Test
    public void test(){
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(util.getFile("/test")))
        ) {
            List<User> users = Arrays.asList(user1, user2);
            for (User user : users) {
                writer.write(user.getExternalCode() + " | ");
                writer.write(user.getName() + " | ");
                writer.write(user.getLastName() + " | ");
                writer.write(user.getGender() + " | ");
                writer.write(user.getBirthDate() + " | ");
                writer.write(user.getEmail() + " | ");
                writer.write(user.isHost() + " | ");
                writer.write(user.getCity() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }
    }

    @Test
    public void verifyWriteUsersToFile() throws IOException {
        List<User> users = Arrays.asList(user1, user2);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(util.getFile("/test")))
        ) {
            for (User user : users) {
                writer.write(user.getExternalCode() + " | ");
                writer.write(user.getName() + " | ");
                writer.write(user.getLastName() + " | ");
                writer.write(user.getGender() + " | ");
                writer.write(user.getBirthDate() + " | ");
                writer.write(user.getEmail() + " | ");
                writer.write(user.isHost() + " | ");
                writer.write(user.getCity() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }

        UserService service = new UserService();
        for (User user : users) {
            service.createUser(user);
        }

        Assert.assertEquals(FileUtils.readLines(util.getFile("/test")), FileUtils.readLines(util.getFile("/test")));
    }

    @Test
    public void verifyUserBecomesHostAndHewHomeCreated() throws IOException {
        List<Home> homeList = new ArrayList<>();
        homeList.add(home1);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(util.getFile("/test")))
        ) {
            for (Home home : homeList) {
                writer.write(home.getHost() + " | ");
                writer.write(home.getCity() + " | ");
                writer.write(home.getHomeType() + " | ");
                writer.write(home.isActive() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }

        HomeService service = new HomeService();
        for (Home home : homeList) {
            service.createHome(user1, home);
        }

        Assert.assertEquals(FileUtils.readLines(util.getFile("/test")), FileUtils.readLines(util.getFile("/test")));
    }

}
