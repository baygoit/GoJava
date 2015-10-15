package com.gojava6.airbnb.dao.jdbc;

import com.gojava6.airbnb.dao.ISubscriberDao;
import com.gojava6.airbnb.model.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubscriberDao extends AbstractDao implements ISubscriberDao {

    public void createSubscriber(Subscriber subscriber) {
        String sqlCode = "INSERT INTO observer VALUES (" + subscriber.getUserId() + ")";
        updateDatabase(sqlCode);
    }

    public void deleteSubscriber(Subscriber subscriber) {
        String sqlCode = "DELETE FROM observer WHERE user_id = " + subscriber.getUserId();
        updateDatabase(sqlCode);
    }

    public List<Subscriber> getSubscriberList() {
        String sqlCode = "SELECT * FROM observer";
        return (List<Subscriber>)(List<?>) readDatabase(sqlCode);
    }

    public Subscriber getSubscriber(Integer userId) {
        String sqlCode = "SELECT * FROM observer WHERE user_id =" + userId;
        List<Subscriber> subscriberList = (List<Subscriber>)(List<?>) readDatabase(sqlCode);
        return subscriberList.get(0);
    }

    @Override
    Object createObject(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");

        Subscriber subscriber = new Subscriber();
        subscriber.setUserId(userId);

        return subscriber;
    }

}
