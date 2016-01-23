package com.gojava6.dao;

import com.gojava6.model.User;

import java.sql.*;

public class UserDAO {

    public void addNewUser(User user) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String addNewUser = "insert into airbnb.users (name, surname, email, userCity) values (?, ?, ?, ?)";

        try {
            statement = DBConnection.prepareStatement(addNewUser);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getUserCity());

            try {
                statement.executeUpdate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User findUserById(int id) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String findUserById = "select * from airbnb.users where idUser=?";
        User user1 = new User();

        try {
            statement =
                    DBConnection.prepareStatement(findUserById);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer idUser = resultSet.getInt("idUser");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String userCity = resultSet.getString("userCity");
                String email = resultSet.getString("email");
                /*System.out.println("ID: " + id +
                        ", Name: " + name +
                        ", Surname: " + surname +
                        ", Email: " + email);*/
                user1 = new User(name, surname, userCity, email);
                //System.out.println(user1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user1;
    }

    /*Works.*/
    public int findUserIdByEmail(String email) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String findUserIdByEmail = "select * from airbnb.users where email=?";
        int idUser = 0;

        try {
            statement =
                    DBConnection.prepareStatement(findUserIdByEmail);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                idUser = resultSet.getInt("idUser");
                //System.out.println(idUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idUser;
    }

    /*Works.*/
    public void getAllUsers() {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        Statement statement = null;
        String getAllUsers = "select * from airbnb.users";

        try {
            statement = DBConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsers);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("idUser");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id +
                        ", Name: " + name +
                        ", Surname: " + surname +
                        ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateUserName(String userName, Integer idUser) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String query = "update airbnb.users set name=? where id=?";

        try {
            statement =
                    DBConnection.prepareStatement(query);
            statement.setString(1, userName);
            statement.setInt(2, idUser);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateUserToHost(String aptCity, String aptType, Integer idUser) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String query = "update airbnb.users set aptCity=? and aptType=? and isHost=1 where id=?";

        try {
            statement =
                    DBConnection.prepareStatement(query);
            statement.setString(1, aptCity);
            statement.setString(2, aptType);
            statement.setInt(3, idUser);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*Works.*/
    public void deleteUserByNameSurname(String userName, String userSurname) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String query = "delete from airbnb.users where name=? and surname=?";

        try {
            statement =
                    DBConnection.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, userSurname);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*Works.*/
    public void deleteUserById(Integer id) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String query = "delete from airbnb.users where idUser=?";

        try {
            statement =
                    DBConnection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
