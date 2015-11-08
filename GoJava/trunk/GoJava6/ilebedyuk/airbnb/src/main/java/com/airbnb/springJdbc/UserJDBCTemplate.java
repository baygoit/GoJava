package com.airbnb.springJdbc;

import com.airbnb.dao.IUserDao;
import com.airbnb.model.User;
import com.airbnb.model.UserType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Игорь on 29.10.2015.
 */
public class UserJDBCTemplate implements IUserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<User> getUserList() {
        String sqlCode = "select * from user;";
        List<User> users = jdbcTemplateObject.query(sqlCode, new UserMapper());
        return users;
    }

    public User getUser(int id) {
        String sqlCode = "select * from user where iduser = ?;";
        User user = jdbcTemplateObject.queryForObject(sqlCode, new Object[]{id}, new UserMapper());
        return user;
    }

    public void updateName(int id, String newName) {
        String sqlCode = "update user set name = ? where iduser = ?;";
        jdbcTemplateObject.update(sqlCode, newName, id);
    }

    public void updateUserType(int id) {
        String sqlCode = "update user set usertype = ? where iduser = ?;";
        jdbcTemplateObject.update(sqlCode, String.valueOf(UserType.HOST), id);
    }

    public void delete(int id) {
        String sqlCode = "delete from user where iduser = ?;";
        jdbcTemplateObject.update(sqlCode, id);
    }

    public void addToDb(User user) {
        String sqlCode = "insert into user values(null, ?, ?, ?, ?, ?);";
        jdbcTemplateObject.update(sqlCode, user.getName(), user.getSurname(), user.getEmail(), user.getCity(), user.getUserType());
    }

//    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("Beans.xml");
//
//        UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
//
//        List<User> users = userJDBCTemplate.getUserList();
//        for (User user : users) {
//            System.out.println(user);
//        }
//
//        //userJDBCTemplate.delete(15);
//
//    }
}
