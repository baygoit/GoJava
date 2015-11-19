package com.azuiev.dao;

import com.azuiev.model.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Masta on 08.10.15.
 */

public class UserDao implements ModelDao<User> {
    static ModelDao dao = new BasicModelDao<User>(User.class);

    public UserDao() {
    }

    @Override
    public List<User> getAll() throws SQLException {
        return dao.getAll();
    }

    @Override
    public User getById(Long id) throws SQLException {
        return (User) dao.getById(id);
    }

    public User login(String email, String password) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<User> list = session.createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password)).list();
        if (list.size() == 0)
            return null;
        else
            return list.get(0);
    }

    @Override
    public void update(User user) throws SQLException {
        dao.update(user);
    }

    @Override
    public void add(User user) throws SQLException {
        dao.add(user);
    }


    @Override
    public void delete(User user) throws SQLException {
        dao.delete(user);
    }
}
