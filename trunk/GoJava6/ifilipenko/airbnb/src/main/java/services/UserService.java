package services;

import dao.file.UserFileDao;
import model.Home;
import model.User;

import java.io.IOException;
import java.util.Random;

public class UserService{
    private UserFileDao userIODao = new UserFileDao();
    private HomeService service = new HomeService();

    public void createUser(User user) throws IOException {
        if(user.getId() == 0){
            user.setId(new Random().nextInt(1000000));
        }
        userIODao.create(user);
    }

    public User getUserByCode(int userCode) throws IOException {
        return userIODao.readByCode(userCode);
    }

    public User getUserByEmail(String email){
        return userIODao.readByEmail(email);
    }

    public void becomeHost(int userCode, Home newHome) throws IOException {
        User host = this.getUserByCode(userCode);
        service.createHome(host, newHome);
    }

    public boolean searchPlace() {
        return false;
    }

}
