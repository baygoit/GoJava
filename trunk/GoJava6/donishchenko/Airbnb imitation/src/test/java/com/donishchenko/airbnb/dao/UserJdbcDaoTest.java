package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dao.old.UserJdbcDao;
import com.donishchenko.airbnb.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class UserJdbcDaoTest extends Assert {

    private UserDao userDao = new UserJdbcDao();
    private User user = new User("Dmitry", "Onishchenko", "sacr8tum@gmail.com");

    @Test
    public void testSave() throws SQLException {
        User host = new User("Dmitry", "Onishchenko", "sacr8tum@gmail.com", true);

        int userId = userDao.save(user);
        int hostId = userDao.save(host);

        //clear
        userDao.delete(userId);
        userDao.delete(hostId);
    }

    @Test
    public void testDelete() throws SQLException {
        int userId = userDao.save(user);
        user.setId(userId);

        assertTrue(userDao.delete(userId));
        assertFalse(userDao.delete(-1));
    }

    @Test
    public void testUpdate() throws SQLException {
        int userId = userDao.save(user);
        user.setId(userId);

        user.setName("Max");
        assertTrue(userDao.update(userId, user));

        // clear
        userDao.delete(userId);
    }

    @Test
    public void testGet() throws SQLException {
        int userId = userDao.save(user);
        user.setId(userId);

        User other = userDao.get(userId);

        assertEquals(user, other);
    }

    @Test
    public void testGetAllUsers() throws SQLException {

    }

    @Test
    public void testGetAllClients() throws SQLException {

    }

    @Test
    public void testGetAllHosts() throws SQLException {

    }
}