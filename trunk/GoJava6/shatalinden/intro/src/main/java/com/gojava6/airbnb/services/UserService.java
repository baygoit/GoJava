package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.userDao;
import com.gojava6.airbnb.user.User;

import java.util.List;

public class UserService {

    public static List<User> getAllUsers() { return userDao.pullAllUsers(); }

    public static User getUserByID(int id) { return userDao.pullUserByID(id); }

    public static void writeUserToDB(User user) {
        userDao.pushUser(user);
    }

    public static void changeClientToHost(User user) {
        userDao.updateUser(user.getUserID(), true);
    }

    public static void deleteUserFromDB(User user) { userDao.deleteUser(user.getUserID()); }

}
