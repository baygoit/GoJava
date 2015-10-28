package com.airbnb.services;

import com.airbnb.dao.IUserDao;
import com.airbnb.model.User;

import java.util.List;


/**
 * Created by Игорь on 11.10.2015.
 */
public class UserService {
    private IUserDao iUserDao;
    private Validator validator = new Validator();

    public UserService(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    public void registerUser(User user) {
        if (validator.isValidData(user)) {
            iUserDao.addToDb(user);
        } else System.out.println("Data isn't valid");
    }

    public void updateName(int id, String newName) {
        iUserDao.updateName(id, newName);
    }

    public User getById(int id){
        return iUserDao.getUser(id);
    }

    public List<User> getAllUsers(){
        return iUserDao.getUserList();
    }

    public void deleteUser(int id){
        iUserDao.delete(id);
    }

    public void becomeHost(int id){
        iUserDao.updateUserType(id);
    }

    public void printUsers(){
        List<User> users = iUserDao.getUserList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
