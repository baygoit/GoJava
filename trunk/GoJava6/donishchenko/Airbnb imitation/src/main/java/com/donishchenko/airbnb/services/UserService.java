package com.donishchenko.airbnb.services;


import com.donishchenko.airbnb.dao.HibernateUserDao;
import com.donishchenko.airbnb.dao.UserDao;
import com.donishchenko.airbnb.model.User;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserService {
    public static Logger log = LogManager.getLogger(UserService.class.getName());

    private UserDao userDao = new HibernateUserDao();

    public void register(User user) throws SQLException {
        log.entry();

//        if (!user.validate()) {
//            log.info(Joiner.on("").join("User ID=", user.getId(), "Fail validation. Registration was rejected."));
//            return;
//        }

        userDao.save(user);
        log.info(Joiner.on("").join("User ID=", user.getId(), " | Successful validation. New User registered!"));
        log.exit(user.getId());
    }

    public void register(String name, String surname, String email, boolean isHost) throws SQLException {
        User user = new User(name, surname, email, isHost);
        register(user);
    }

    public void deleteUser(int id) {
        try {
            userDao.delete(id);
        } catch (SQLException ex) {
            //TODO handle exception
            ex.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        deleteUser(user.getId());
    }

    public void updateUser(int id, User user) {
        try {
            userDao.update(id, user);
        } catch (SQLException e) {
            //TODO handle exception
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = Collections.emptyList();

        try {
            list = userDao.getAllUsers();
        } catch (SQLException e) {
            //TODO handle exception
            e.printStackTrace();
        }

        return list;
    }

    public List<User> getAllClients() {
        List<User> list = Collections.emptyList();

        try {
            list = userDao.getAllClients();
        } catch (SQLException e) {
            //TODO handle exception
            e.printStackTrace();
        }

        return list;
    }

    public List<User> getAllHosts() {
        List<User> list = Collections.emptyList();

        try {
            list = userDao.getAllHosts();
        } catch (SQLException e) {
            //TODO handle exception
            e.printStackTrace();
        }

        return list;
    }

    public User login(String login, String password) {
        User user = null;
        try {
            user = userDao.getByLoginPassword(login, password);
        } catch (SQLException ex) {
            //TODO handle exception
            ex.printStackTrace();
        }

        return user;
    }
}
