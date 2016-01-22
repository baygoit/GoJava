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

    /*public void addNewUser(User user) {
        Session session = getSessionFactory().openSession();
        String sqlQuery = "INSERT INTO airbnb.user (userName, userSurname, email, userCity) values (?, ?, ?, ?)";
        SQLQuery query = session.createSQLQuery(sqlQuery);
        query.
                update(sqlQuery,
                new Object[]{user.getUserName(),
                        user.getUserSurname(),
                        user.getEmail(),
                        user.getUserCity()});
    }*/

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

    /*public User findUserById(int idUser) {
        String sqlQuery = "SELECT * FROM airbnb.user WHERE idUser=?";
        return this.getJdbcTemplate().queryForObject(sqlQuery, new Object[]{idUser}, new UserRowMapper());
    }

    public List<User> getAllUsers() {
        String sqlQuery = "SELECT * FROM airbnb.user";
        return this.getJdbcTemplate().query(sqlQuery, new UserRowMapper());
    }

    public void deleteUserById(int idUser) {
        String sqlQuery = "DELETE FROM airbnb.user WHERE idUser=?";
        this.getJdbcTemplate().update(sqlQuery, new Object[]{idUser});
    }

    public void deleteUserByNameSurname(String userName, String userSurname) {
        String sqlQuery = "DELETE FROM airbnb.user WHERE userName=? and userSurname=?";
        this.getJdbcTemplate().update(sqlQuery, new Object[]{userName,userSurname});
    }*/

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
