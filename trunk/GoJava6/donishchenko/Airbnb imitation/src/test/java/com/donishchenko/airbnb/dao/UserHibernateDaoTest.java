package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserHibernateDaoTest {

    private UserHibernateDao dao = new UserHibernateDao();
    private User user = new User("testuser", "secretpassword", "sacr8tum@gmail.com", true, "Dmitry", "Onishchenko");

    @Before
    @After
    /**
     * Set user.id to 0
     */
    public void setUpUser() {
        user.setId(0);
    }

    @Test
    public void testSave() {
        dao.save(user);
        dao.delete(user.getId());
    }

    @Test
    public void testGet() {
        dao.save(user);

        User receivedUser = dao.get(user.getId());
        assertNotNull("Received user is not null", receivedUser);
        assertEquals("Saved user equals received user", user.getId(), receivedUser.getId());

        dao.delete(user.getId());
    }

    @Test
    public void testUpdate() {
        String oldLogin = user.getLogin();

        dao.save(user);

        user.setLogin("NewLogin");
        assertTrue("Successful update returns true", dao.update(user));

        Integer oldId = user.getId();
        user.setId(-1);
        assertFalse("Unsuccessful update returns false", dao.update(user));
        user.setId(oldId);

        User updatedUser = dao.get(user.getId());
        assertEquals("Detached user equals updated user from DB", user, updatedUser);

        dao.delete(user.getId());
        user.setLogin(oldLogin);
    }

    @Test
    public void testDelete() {
        dao.save(user);
        assertTrue("Successful delete returns true", dao.delete(user.getId()));
        assertFalse("Unsuccessful delete returns false", dao.delete(-1));
    }

    @Test
    public void testGetByLoginPassword() {
        dao.save(user);

        User receivedUser = dao.getByLoginPassword(user.getLogin(), user.getPassword());
        assertEquals("Saved user equals received user", user, receivedUser);

        assertNull("If there is no match - null", dao.getByLoginPassword("WrongLogin", "OrWrongPassword"));

        dao.delete(user.getId());
    }

    @Test
    public void testGetAllUsers() {
        dao.save(user);

        List<User> list = dao.getAllUsers();
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(user.getId());
    }

    @Test
    public void testGetAllClients() {
        user.setHost(false);
        dao.save(user);

        List<User> list = dao.getAllClients();
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(user.getId());
        user.setHost(true);
    }

    @Test
    public void testGetAllHosts() {
        user.setHost(true);
        dao.save(user);

        List<User> list = dao.getAllHosts();
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(user.getId());
    }
}