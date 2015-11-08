package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dbutils.HibernateDbUtils;
import com.donishchenko.airbnb.dbutils.QueryBuilder;
import com.donishchenko.airbnb.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class HibernateUserDao implements UserDao {
    private SessionFactory sessionFactory;

    public HibernateUserDao() {
        sessionFactory = HibernateDbUtils.getSessionFactory();
    }

    @Override
    public Integer save(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Integer userId = null;

        try {
            session.beginTransaction();

            userId = (Integer) session.save(user);

            session.getTransaction().commit();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return userId;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            User user = session.load(User.class, id);
            session.delete(user);

            session.getTransaction().commit();

            return true;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }

    @Override
    public boolean update(Integer id, User user) throws SQLException {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            User existingUser = session.load(User.class, id);
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setEmail(user.getEmail());

            session.flush();

            session.getTransaction().commit();

            return true;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }

    @Override
    public User get(Integer id) throws SQLException {
        Session session = sessionFactory.openSession();
        User user = null;

        try {
            session.beginTransaction();

            user = session.get(User.class, id);

            session.getTransaction().commit();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public User getByLoginPassword(String login, String password) throws SQLException {
        Session session = sessionFactory.openSession();
        User user = null;

        try {
            session.beginTransaction();

            Query query = session.createQuery("FROM User WHERE login = :login and password = :password");
            query.setParameter("login", login);
            query.setParameter("password", password);

            user = (User) query.uniqueResult();

            session.getTransaction().commit();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
//        Session session = sessionFactory.openSession();
//        List<User> users = Collections.emptyList();
//
//        try {
//            session.beginTransaction();
//
//            users = session.createQuery("FROM user").list();
//
//            session.getTransaction().commit();
//        } catch (HibernateException ex) {
//            session.getTransaction().rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        return users;

        return getAllUsersWithParameters();
    }

    @Override
    public List<User> getAllClients() throws SQLException {
        return getAllUsersWithParameters("isHost", false);
    }

    @Override
    public List<User> getAllHosts() throws SQLException {
        return getAllUsersWithParameters("isHost", true);
    }

    private List<User> getAllUsersWithParameters(Object...args) {
        QueryBuilder queryBuilder = new QueryBuilder("FROM User");
        queryBuilder.parseHql(args);

        Session session = sessionFactory.openSession();
        List<User> users = Collections.emptyList();

        try {
            session.beginTransaction();

            Query query = session.createQuery(queryBuilder.getQuery());
            int i = 1;
            for (Object value : queryBuilder.values()) {
                query.setParameter(1, value);
            }

            users = query.list();

            session.getTransaction().commit();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return users;
    }
}
