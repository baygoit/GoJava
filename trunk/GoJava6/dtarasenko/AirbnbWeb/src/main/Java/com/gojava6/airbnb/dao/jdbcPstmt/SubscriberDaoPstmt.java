package com.gojava6.airbnb.dao.jdbcPstmt;

import com.gojava6.airbnb.dao.ISubscriberDao;
import com.gojava6.airbnb.model.Subscriber;
import com.gojava6.airbnb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberDaoPstmt extends AbstractDaoPstmt implements ISubscriberDao {


    public void createSubscriber(Subscriber subscriber) {
        String sqlCode = "INSERT INTO observer VALUES (?)";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, subscriber.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteSubscriber(Subscriber subscriber) {
        String sqlCode = "DELETE FROM observer WHERE user_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, subscriber.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Subscriber> getSubscriberList() {
        List<Subscriber> subscriberList = new ArrayList<Subscriber>();

        String sqlCode = "SELECT * FROM observer";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("user_id");

                Subscriber subscriber = new Subscriber();
                subscriber.setUserId(userId);

                subscriberList.add(subscriber);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return subscriberList;
    }

    public Subscriber getSubscriber(Integer user_id) {
        Subscriber subscriber = null;
        String sqlCode = "SELECT * FROM observer WHERE user_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");

                subscriber = new Subscriber();
                subscriber.setUserId(userId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return subscriber;
    }
}
