package services;

import dao.io.HomeIODao;
import model.Home;
import model.User;

import java.io.IOException;

public class HomeService {

    HomeIODao homeIODao = new HomeIODao();

    public void createHome(User host, Home home) throws IOException {
        homeIODao.create(host, home);
    }
}
