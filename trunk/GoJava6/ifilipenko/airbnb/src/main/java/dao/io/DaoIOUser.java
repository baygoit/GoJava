package dao.io;

import dao.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DaoIOUser implements Dao {


    @Override
    public void createAll() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/test/users")));
        ArrayList users = new ArrayList();
        //User user1 = new User("Jennifer", "Richard", GenderType.FEMALE, );

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
