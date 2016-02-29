package com.shcherbak.processing;

import com.shcherbak.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public class UserJDBC {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create( Boolean type, String firstname, String lastname, String email,
                       Boolean notify, Date date, String password, String login) {
        String SQL = "insert into users values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL, new Object[]{null, type, firstname, lastname, email,
                notify, date, password, login});
        //System.out.println("Created Record Name = " + firstname);
    }

    public User getUserByID(Integer id) {
        String SQL = "select * from users where id = ?";
        return (User)jdbcTemplate.queryForObject(SQL,
                new Object[]{id}, new UserMapper());
    }

    public Integer getUserID(String field, String value) {
        String SQL = "select id from users where " + field + " = " + value ;
        //String SQL = "select id from users where email = 'marlow@site.com'";
        return jdbcTemplate.queryForInt(SQL);

    }

    public List<User> getUsersByField(String field, String value) {
        String SQL = "select * from users where " + field + " = " + value ;
        return jdbcTemplate.query(SQL, new UserMapper());
    }

    public List<User> listUsers() {
        String SQL = "select * from users";
        return jdbcTemplate.query(SQL,  new UserMapper());

    }

    public void delete(Integer id){
        String SQL = "delete from users where id = ?";
        jdbcTemplate.update(SQL, new Object[]{id});
        //System.out.println("Deleted Record with ID = " + id );
    }

    public void update(Integer id, Boolean notify){
        String SQL = "update users set notify = ? where id = ?";
        jdbcTemplate.update(SQL, new Object[]{ notify, id});
        //System.out.println("Updated Record with ID = " + id );

    }
}
