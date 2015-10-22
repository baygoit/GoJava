package dao.io;

import dao.Dao;
import model.Home;
import model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeIODao implements Dao {

    private List<Home> homeList = new ArrayList<>();
    private File file = new File(this.getClass().getResource("/home").getFile());

    public void create(User host, Home newHome) throws IOException {
        newHome.setHost(host);
        homeList.add(newHome);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
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
    }


}
