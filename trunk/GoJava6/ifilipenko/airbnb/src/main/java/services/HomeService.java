package services;

import dao.file.HomeFileDao;
import model.Home;
import model.User;

import java.io.IOException;

public class HomeService{
    private HomeFileDao homeFileDao = new HomeFileDao();


    public void createHome(User host, Home home) throws IOException {
        homeFileDao.create(host, home);
    }

}
