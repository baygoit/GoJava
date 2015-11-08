package com.airbnb.springJdbc;

import com.airbnb.dao.ISubscriberDao;
import com.airbnb.model.User;
import com.airbnb.observer.Observer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Игорь on 30.10.2015.
 */
public class SubscriberJDBCTemplate implements ISubscriberDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Observer> getUserList() {
        String sqlCode = "SELECT user.* FROM airbnb.observer join airbnb.user on idobserver = iduser;";
        List<Observer> observers = jdbcTemplateObject.query(sqlCode, new SubscribersDataMapper());
        return observers;
    }

    public Observer getUser(int id) {
        String sqlCode = "SELECT user.* FROM user join observer on idobserver = iduser where idobserver = ?;";
        Observer observer = jdbcTemplateObject.queryForObject(sqlCode, new Object[]{id}, new SubscribersDataMapper());
        return observer;
    }

    public void delete(int id) {
        String sqlCode = "delete from observer where id = ?;";
        jdbcTemplateObject.update(sqlCode, id);
    }

    public void addToDb(Observer observer) {
        User user = (User) observer;
        String sqlCode = "insert into observer values(?);";
        jdbcTemplateObject.update(sqlCode, user.getUserId());
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        SubscriberJDBCTemplate subscriberJDBCTemplate = (SubscriberJDBCTemplate)context.getBean("subscribersJDBCTemplate");

        List<Observer> observers = subscriberJDBCTemplate.getUserList();
        for (Observer observer : observers) {
            User user = (User) observer;
            System.out.println(user);
        }

    }
}
