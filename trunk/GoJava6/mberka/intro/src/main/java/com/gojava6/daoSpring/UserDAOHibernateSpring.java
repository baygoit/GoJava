package com.gojava6.daoSpring;

import com.gojava6.modelSpring.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository /*Spring Annotation for DAO @Component.*/
public class UserDAOHibernateSpring {
    /*Using Spring along with Hibernate.*/
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewUser(User user) {
        /*HQL supports INSERT INTO clause only where records can be inserted
        from one object to another object. That means that you must have
        an old_modelObject table in DB where you keep modelObjects.
        If you need to insert modelObject into DB, use session.save(modelObject).*/
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public List findUserIdByEmail(String email) {
        String hqlQuery = "SELECT idUser FROM User WHERE email = :email";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hqlQuery);
        query.setParameter("email", email);
        List result = query.list();
        return result;
    }

    public List findUserNameById(int idUser) {
        String hqlQuery = "SELECT userName FROM User WHERE idUser = :idUser";
        Query query = getSessionFactory().
                openSession().
                createQuery(hqlQuery).
                setParameter("idUser", idUser);
        List result = query.list();
        return result;
    }

    public User findUserById(int idUser) {
        String hqlQuery = "FROM User WHERE idUser = :idUser";
        Query query = getSessionFactory().
                openSession().
                createQuery(hqlQuery).
                setParameter("idUser", idUser);
        //User result = (User) query.list();
        User result = (User) query.uniqueResult();
        return result;
    }

    public List<User> getAllUsers() {
        String hqlQuery = "FROM User";
        Query query = getSessionFactory().
                openSession().
                createQuery(hqlQuery);
        return query.list();
    }

    public void deleteUserById(int idUser) {
        String hqlQuery = "DELETE FROM User WHERE idUser = :idUser";
        Query query = getSessionFactory().
                openSession().
                createQuery(hqlQuery).
                setParameter("idUser", idUser);
        query.executeUpdate();
    }

    public void deleteUserByNameSurname(String userName, String userSurname) {
        String hqlQuery = "DELETE FROM User WHERE userName = :userName and userSurname = :userSurname";
        Query query = getSessionFactory().
                openSession().
                createQuery(hqlQuery).
                setParameter("userName", userName).
                setParameter("userSurname", userSurname);
        query.executeUpdate();
    }

    /*public void updateUserToHost(int idUser) {
        String sqlQuery = "UPDATE airbnb.user SET isHost=1 where idUser=?";
        getJdbcTemplate().update(sqlQuery, new Object[]{idUser});
    }*/

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("idUser"));
            user.setUserName(resultSet.getString("userName"));
            //user.setUserSurname(resultSet.getString("userSurname"));
            //user.setUserCity(resultSet.getString("userCity"));
            //user.setEmail(resultSet.getString("email"));
            return user;
        }
    }
}
