package services;

import dao.file.HomeFileDao;
import entity.Home;

import java.io.IOException;
import java.util.List;

public class HomeService{
    private HomeFileDao homeFileDao = new HomeFileDao();

    public void createHome(Home home) throws IOException {
        homeFileDao.create(home);
    }

    public List<Home> realAllHomes() throws IOException {
        return homeFileDao.readAll();
    }

}
