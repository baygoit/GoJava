package com.donishchenko.airbnb.services;


import com.donishchenko.airbnb.dao.UserDao;
import com.donishchenko.airbnb.model.User;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    public static Logger log = LogManager.getLogger(UserService.class.getName());

    @Autowired
    private UserDao userDao;

    public void register(User user) {
        log.entry();

        userDao.save(user);

        log.info(Joiner.on("").join("User ID=", user.getId(), " | Successful registered!"));
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
        return userDao.getAllUsers();
    }

    public List<User> getAllClients() {
        return userDao.getAllClients();
    }

    public List<User> getAllHosts() {
        return userDao.getAllHosts();
    }

    public User login(String login, String password) {
        return userDao.getByLoginPassword(login, password);
    }
}
