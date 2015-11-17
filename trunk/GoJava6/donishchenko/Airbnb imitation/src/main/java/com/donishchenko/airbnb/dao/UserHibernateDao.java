package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dbutils.HibernateDefaultRawDao;
import com.donishchenko.airbnb.model.User;

import java.util.List;

public class UserHibernateDao implements UserDao {
    private HibernateDefaultRawDao defaultDao = new HibernateDefaultRawDao(User.class);

    public UserHibernateDao() {}

    @Override
    public void save(User user) {
        defaultDao.save(user);
    }

    @Override
    public User get(Integer id) {
        return defaultDao.get(id);
    }

    @Override
    public boolean update(User user) {
        return defaultDao.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return defaultDao.delete(id);
    }

    @Override
    public User getByLoginPassword(String login, String password) {
        return (User) defaultDao.getUniqueResult("login", login, "password", password);
    }

    @Override
    public List<User> getAllUsers() {
        return defaultDao.getList();
    }

    @Override
    public List<User> getAllClients() {
        return defaultDao.getList("isHost", false);
    }

    @Override
    public List<User> getAllHosts() {
        return defaultDao.getList("isHost", true);
    }
}
