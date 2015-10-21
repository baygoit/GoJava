package dao.io;

import dao.Dao;
import model.Home;
import model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractIODao implements Dao{
    public abstract void create(File file, Home home, int userExternalCode) throws IOException;
    public abstract void create(File file, User user) throws IOException;
    public abstract void read();
    public abstract void update();
    public abstract void delete();
}

