package dao.io;

import dao.Dao;
import model.Home;
import model.HomeType;
import model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeIODao implements Dao{

    @Override
    public void createAll(File file) throws IOException {
        User host1 = new UserIODao().getUserByCode(1);
        Home home1 = new Home(host1, "Miami", HomeType.APARTMENT);
        List<Home> homeList = new ArrayList<>();
        homeList.add(home1);

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
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
    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
