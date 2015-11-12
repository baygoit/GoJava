package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dbutils.QueryBuilder;
import com.donishchenko.airbnb.model.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserHibernateDao extends HibernateDefaultDao implements UserDao {
    private static final String getUserByLoginPassword =
            "FROM User WHERE login = :login and password = :password";

    private static final String getAllUsersQuery =
            "FROM User";

    public UserHibernateDao() {
        super(User.class);
    }

    @Override
    public void save(User user) {
        super.save(user);
    }

    @Override
    public User get(Integer id) {
        return (User) super.get(id);
    }

    @Override
    public boolean update(User user) {
        return super.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public User getByLoginPassword(String login, String password) {
        Session session = sessionFactory.openSession();

        Query query = session.createQuery(getUserByLoginPassword);
        query.setString("login", login);
        query.setString("password", password);

        User user = (User) query.uniqueResult();

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return super.getAll();
    }

    @Override
    public List<User> getAllClients() {
        return getAllUsersWithParameter("isHost", false);
    }

    @Override
    public List<User> getAllHosts() {
        return getAllUsersWithParameter("isHost", true);
    }

    private List<User> getAllUsersWithParameter(Object...args) {
        QueryBuilder queryBuilder = new QueryBuilder(getAllUsersQuery);
        queryBuilder.parseHql(args);

        Session session = sessionFactory.openSession();
        Query query = session.createQuery(queryBuilder.getQuery());
        int i = 1;
        for (Object value : queryBuilder.values()) {
            query.setParameter(i, value);
        }

        List<User> list = query.list();

        return list;
    }
}
