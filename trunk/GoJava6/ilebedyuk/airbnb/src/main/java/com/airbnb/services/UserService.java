package com.airbnb.services;

import com.airbnb.dao.IUserDao;
import com.airbnb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Игорь on 11.10.2015.
 */
@Component
public class UserService {
    @Autowired
    private IUserDao iUserDao;

    private Validator validator = new Validator();


    public UserService() {}

    public UserService(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    public void registerUser(User user) throws NullPointerException {
        if (validator.isValidData(user)) {
            iUserDao.addToDb(user);
        } else throw new NullPointerException();
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

    public boolean isRegisterUser(String email, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void printUsers(){
        List<User> users = iUserDao.getUserList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
