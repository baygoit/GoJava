package com.gojava6.airbnb.dao.jdbcPstmt;

import com.gojava6.airbnb.dao.IUserDao;
import com.gojava6.airbnb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoPstmt extends AbstractDaoPstmt implements IUserDao {

    public void createUser(User user) {
        String sqlCode = "INSERT INTO user VALUES (NULL, ?, ?, ?, ?)";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserType());
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

    public void updateUser(User user) {
        String sqlCode = "UPDATE user SET name = ?, surname = ?, email = ?, user_type = ? WHERE user_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserType());
            pstmt.setInt(5, user.getUserId());
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

    public void deleteUser(User user) {
        String sqlCode = "DELETE FROM user WHERE user_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, user.getUserId());
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

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();

        String sqlCode = "SELECT * FROM user";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String userType = rs.getString("user_type");

                User user = new User();
                user.setUserId(userId);
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setUserType(userType);

                userList.add(user);
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

        return userList;
    }

    public User getUser(Integer user_id) {
        User user = null;
        String sqlCode = "SELECT * FROM user WHERE user_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String userType = rs.getString("user_type");

                user = new User();
                user.setUserId(userId);
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setUserType(userType);
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
        return user;
    }

}
