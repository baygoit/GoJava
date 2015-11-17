package com.azuiev.dao;
import com.azuiev.model.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 08.10.15.
 */
//TODO hibernate
public class UserDao implements ModelDao {


    public UserDao() {


    }
    @Override
    public List<User> getAll() throws SQLException {

        return null;
    }

    @Override
    public User getById(Long id) throws SQLException {

         return null;

    }

    public User login(String email, String password) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<User> list = session.createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password",password)).list();
        if (list.size()==0)
            return null;
        else
            return list.get(0);
    }

    @Override
    public void update(Object obj) {
        //TODO
    }

    @Override
    public void add(Object obj) {
        //TODO
    }


    @Override
    public void delete(Object obj) {
        //TODO
    }
}
