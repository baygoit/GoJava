package io;

import dao.io.MyUtil;
import model.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ReservationService;
import services.UserService;

import java.io.BufferedWriter;
import java.io.File;
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
    private MyUtil util = new MyUtil();

    private File actualUser = util.getFile("/users");
    private File expectedUser = util.getFile("/testusers");

    private File actualHome = new File(this.getClass().getResource("/home").getFile());
    private File expectedHome = new File(this.getClass().getResource("/testhome").getFile());

    private File expectedRes = new File(this.getClass().getResource("/reservation").getFile());

    @Before
    public void init() {
        user1 = new User(1, "Jennifer", "Richard", GenderType.FEMALE, new Date(11011999), "jr@gmail.com", CityList.MIAMI);
        user2 = new User(2, "Bridget", "Raabe", GenderType.FEMALE, new Date(12011999), "br@gmail.com", CityList.NEW_YORK);
        home1 = new Home(user1, CityList.MIAMI, HomeType.APARTMENT);
    }

    @Test
    public void verify_UserRegistration() throws IOException {
        List<User> users = Arrays.asList(user1, user2);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(expectedUser))
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
            service.userRegistration(user);
        }

        Assert.assertEquals(FileUtils.readLines(expectedUser),
                FileUtils.readLines(actualUser));
    }

    @Test
    public void verify_UserBecomesHostAndHewHomeCreated() throws IOException {
        List<Home> homeList = new ArrayList<>();
        homeList.add(home1);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(expectedHome))
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

        /*----------------------------------------------------*/
        List<User> users = Arrays.asList(user1, user2);
        UserService uService = new UserService();
        for (User user : users) {
            uService.userRegistration(user);
        }
        UserService service = new UserService();
        for (Home home : homeList) {
            service.becomeHost(1, home);
        }

        Assert.assertEquals(FileUtils.readLines(expectedHome), FileUtils.readLines(actualHome));
    }

    @Test
    public void verify_UserBooksHome() throws IOException {
        Reservation res = new Reservation(user2, home1, new Date(10012015), new Date(15012016));
        List<Reservation> reservations = Arrays.asList(res);

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(expectedRes))
        ) {
            for (Reservation reservation : reservations) {
                writer.write(reservation.getUser() + " | ");
                writer.write(reservation.getHome() + " | ");
                writer.write(reservation.getStart() + " | ");
                writer.write(reservation.getEnd() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }

         /*----------------------------------------------------*/
        List<User> users = Arrays.asList(user1, user2);
        UserService uService = new UserService();
        for (User user : users) {
            uService.userRegistration(user);
        }

        List<Home> homeList = Arrays.asList(home1);
        UserService hService = new UserService();
        for (Home home : homeList) {
            hService.becomeHost(1, home);
        }

        ReservationService rService = new ReservationService();
        for (Reservation reservation : reservations) {
            rService.bookHome(reservation);
        }
    }

}
