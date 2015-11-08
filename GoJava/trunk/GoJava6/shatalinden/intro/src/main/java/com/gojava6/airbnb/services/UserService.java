package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.UserDao;
import com.gojava6.airbnb.user.User;

import java.util.List;

public class UserService {

    public static List<User> getAllUsers() { return UserDao.pullAllUsers(); }

    public static User getUserByID(int id) { return UserDao.pullUserByID(id); }

    public static User getUserByEmail(String email) { return UserDao.pullUserByEmail(email); }

    public static void writeUserToDB(User user) { UserDao.pushUser(user); }

    public static void changeClientToHost(User user) {
        user.becomeHost();
        UserDao.updateUser(user.getUserID(), true);
    }

    public static void deleteUserFromDB(User user) { UserDao.deleteUser(user.getUserID()); }

}
