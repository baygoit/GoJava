package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.UserDao;
import com.gojava6.airbnb.model.User;
import com.gojava6.airbnb.model.UserType;

import java.util.List;

public class UserService  {

    UserDao userDao = new UserDao();

    public void createUser(String name, String surname, String email, UserType userType) {
        ValidationService validationService = new ValidationService();

        if (validationService.isValidName(name) && validationService.isValidSurname(surname)
                && validationService.isValidEmail(email)) {
            userDao.createUser(name, surname, email, userType);
        }
    }

    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    public void updateUserTypeToHost(Integer userId) {
        userDao.updateUserTypeToHost(userId);
    }

    public User getUser(Integer userId) {
        return (User) userDao.getUser(userId);
    }

    public List<User> getUserList() {
        return (List<User>)(List<?>) userDao.getUserList();
    }

    public void printAllUsers(){
        List<User> userList = getUserList();

        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

}
