package com.gojava6.daoSpring;

import com.gojava6.modelSpring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class UserDAO extends JdbcDaoSupport {

    /*Spring DAO Support: (1) extending JdbcDaoSupport
    (2) adding "this" to getJdbcTemplate(). in methods
    to refer parent DAO Support class
    (3) remove dataSource & jdbcTemplate fields and get-/setters*/

    /*@Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }*/

    /*NamedParameterJdbcTemplate*/
    /*@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public void addNewUser(User user) {
        String sqlQuery = "INSERT INTO airbnb.user (userName, userSurname, email, userCity) " +
                "values (:userName, :userSurname, :email, :userCity)";
        SqlParameterSource namedParameterSource = new MapSqlParameterSource()
                .addValue("userName", user.getUserName())
                .addValue("userSurname", user.getUserSurname())
                .addValue("email", user.getEmail())
                .addValue("userCity", user.getUserCity());
        getNamedParameterJdbcTemplate().update(sqlQuery, namedParameterSource);
    }*/

    public void addNewUser(User user) {
        String sqlQuery = "INSERT INTO airbnb.user (userName, userSurname, email, userCity) values (?, ?, ?, ?)";
        /*getJdbcTemplate().update*/
        this.getJdbcTemplate().update(sqlQuery,
                new Object[]{user.getUserName(),
                        user.getUserSurname(),
                        user.getEmail(),
                        user.getUserCity()});
    }

    public int findUserIdByEmail(String email) {
        String sqlQuery = "SELECT * FROM airbnb.user WHERE email=?";
        return this.getJdbcTemplate().queryForObject(sqlQuery, Integer.class);
    }

    public String findUserNameById(int idUser) {
        String sqlQuery = "SELECT userName FROM airbnb.user WHERE idUser=?";
        return this.getJdbcTemplate().queryForObject(sqlQuery, new Object[]{idUser}, String.class);
    }

    public User findUserById(int idUser) {
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
