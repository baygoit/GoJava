package com.gojava6.airbnb.users;

import com.gojava6.airbnb.application.Validator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.gojava6.airbnb.application.JDBC.*;

public class UserController {

    public void createUser(String name, String surname, String email, UserType userType) {

        Validator validator = new Validator();

        if (validator.isValidName(name) && validator.isValidSurname(surname) && validator.isValidEmail(email)) {
            try {
                Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
                Statement stmt = null;

                try {
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO user VALUES (null, '"
                            + name + "', '"
                            + surname + "', '"
                            + email + "', '"
                            + userType.getUserType() + "')";

                    stmt.executeUpdate(sql);
                } catch (SQLException ex) {
                    System.out.println("SQL query is no correct");
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } finally {
                        conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.out.println("No connection");
            }
        }
    }

    public void updateUserTypeToHost(Integer userId) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                String sql = "UPDATE user SET user_type = 'host' WHERE user_id = " + userId;

                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println("SQL query is no correct");
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } finally {
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("No connection");
        }
    }

    public void deleteUser(Integer userId) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                String sql = "DELETE FROM user WHERE user_id = " + userId;
                stmt.executeUpdate(sql);
                System.out.println("User (ID=" + userId + ") is deleted");
            } catch (SQLException ex) {
                System.out.println("SQL query is no correct");
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } finally {
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("No connection");
        }
    }

    public User getUser(Integer userId) {
        User user = null;

        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM user WHERE user_id =" + userId;
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int user_Id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String email = rs.getString("email");
                    String userType = rs.getString("user_type");

                    user = new User();
                    user.setUserId(user_Id);
                    user.setName(name);
                    user.setSurname(surname);
                    user.setEmail(email);
                    user.setUserType(userType);
                }
            } catch (SQLException ex) {
                System.out.println("SQL query is no correct");
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } finally {
                        conn.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("No connection");
        }
        return user;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();

        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM user";
                rs = stmt.executeQuery(sql);

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
            } catch (SQLException ex) {
                System.out.println("SQL query is no correct");
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } finally {
                        conn.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("No connection");
        }

        return userList;
    }

    public void showAllUsers() {
        List<User> userList = getUserList();

        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}
