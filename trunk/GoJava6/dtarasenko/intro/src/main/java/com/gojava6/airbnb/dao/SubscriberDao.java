package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubscriberDao extends AbstractDao implements IDao{

    public void createObject(Object o) {
        if (o instanceof Subscriber) {
            Subscriber subscriber = (Subscriber) o;
            String sqlCode = "INSERT INTO observer VALUES ("
                    + subscriber.getUserId() + ")";
            updateDatabase(sqlCode);
        }
    }

    public void deleteObject(Integer i) {
        String sqlCode = "DELETE FROM observer WHERE user_id = " + i;
        updateDatabase(sqlCode);
    }

    public void updateObject(Integer i) {

    }

    public Object getObject(Integer i) {
        return null;
    }

    public List<Object> getObjectList() {
        String sqlCode = "SELECT * FROM observer";
        return readDatabase(sqlCode);
    }

    @Override
    Object createObject(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");

        Subscriber subscriber = new Subscriber();
        subscriber.setUserId(userId);

        return subscriber;
    }

}
