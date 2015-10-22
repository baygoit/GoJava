package services;

import dao.io.UserIODao;
import model.Home;
import model.User;

import java.io.IOException;

public class UserService {
    HomeService hs = new HomeService();
    private UserIODao userIODao = new UserIODao();

    public void createUser(User user) throws IOException {
        userIODao.create(user);
    }

    public void becomeHost(int userCode, Home newHome) throws IOException {
        User host = userIODao.getUserByCode(userCode);
        host.setHost(true);
        userIODao.create(host);
        hs.createHome(host, newHome);
    }

    public boolean searchPlace() {
        return false;
    }


}
