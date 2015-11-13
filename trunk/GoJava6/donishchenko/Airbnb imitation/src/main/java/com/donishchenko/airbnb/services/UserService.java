package com.donishchenko.airbnb.services;


import com.donishchenko.airbnb.dao.UserDao;
import com.donishchenko.airbnb.dao.UserHibernateDao;
import com.donishchenko.airbnb.model.User;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class UserService {
    public static Logger log = LogManager.getLogger(UserService.class.getName());

    private UserDao userDao = new UserHibernateDao();

    public void register(User user) {
        log.entry();

        userDao.save(user);

        log.info(Joiner.on("").join("User ID=", user.getId(), " | Successful validation. New User registered!"));
        log.exit(user.getId());
    }

    public boolean deleteUser(Integer id) {
        return userDao.delete(id);
    }

    public boolean deleteUser(User user) {
        return deleteUser(user.getId());
    }

    public boolean updateUser(User user) {
        return userDao.update(user);
    }

    public List<User> getAllUsers() {
        List<User> list = Collections.emptyList();

        list = userDao.getAllUsers();

        return list;
    }

    public List<User> getAllClients() {
        List<User> list = Collections.emptyList();

        list = userDao.getAllClients();

        return list;
    }

    public List<User> getAllHosts() {
        List<User> list = Collections.emptyList();

        list = userDao.getAllHosts();

        return list;
    }

    public User login(String login, String password) {
        return userDao.getByLoginPassword(login, password);
    }
}
