//package com.gojava6.airbnb;
//
//import com.gojava6.airbnb.apartment.Apartment;
//import com.gojava6.airbnb.user.User;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class JDBCStatement {
//
////    public static void main(String[] args) throws SQLException {
////        retrieveUser();
//////        update();
//////        insert();
////    }
//
//    public static List<User> retrieveUser() throws SQLException {
//        List<User> users = new ArrayList<>();
//        Connection connection = null;
//        Statement stmt = null;
//        String query = "select * from users";
//
//        try {
//            connection = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "chuchko123");
//
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                    int id = rs.getInt("id");
//                    String name = rs.getString("name");
//                    String surname = rs.getString("surname");
//                    String email = rs.getString("email");
//                    int userType = rs.getInt("usertype");
//                    System.out.println("id: " + id + ", firstname: " + name + ", lastname: " + surname + ", email: " +
//                            email + ", userType : " + userType);
//                users.add(new User(name, surname, email, userType, id));
//            }
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return users;
//        } finally {
//            connection.close();
//        }
//        return users;
//    }
//
//    public static List<User> retrieveApartments() throws SQLException {
//        List<User> users = new ArrayList<>();
//        Connection connection = null;
//        Statement stmt = null;
//        String query = "select * from apartments join users on apartments.userID = users.id";
//
//        try {
//            connection = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "chuchko123");
//
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                int apartmentID = rs.getInt("apartmentID");
//                String city = rs.getString("city");
//                String type = rs.getString("type");
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String email = rs.getString("email");
//                int userType = rs.getInt("usertype");
////                System.out.println("User id: " + apartmentID + ", firstname: " + name + ", lastname: " + surname + ", email: " +
////                        email + ", userType : " + userType);
//                users.add(new User(name, surname, email, userType, id).addApartments(new Apartment(type, city, apartmentID, id)));
//            }
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return users;
//        } finally {
//            connection.close();
//        }
//        return users;
//    }
//
//    public static List<User> retrieveReservationDates() throws SQLException {
//        List<User> users = new ArrayList<>();
//        Connection connection = null;
//        Statement stmt = null;
//        String query = "select * from reservationdates join apartments on reservationdates.apartmentID = apartments.apartmentID join users on apartments.userID = users.id";
//
//        try {
//            connection = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "chuchko123");
//
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                int apartmentID = rs.getInt("apartmentID");
//                String city = rs.getString("city");
//                String type = rs.getString("type");
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String email = rs.getString("email");
//                int userType = rs.getInt("usertype");
////                System.out.println("User id: " + apartmentID + ", firstname: " + name + ", lastname: " + surname + ", email: " +
////                        email + ", userType : " + userType);
//                users.add(new User(name, surname, email, userType, id).addApartments(new Apartment(type, city, apartmentID, id)));
//            }
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return users;
//        } finally {
//            connection.close();
//        }
//        return users;
//    }
//
//    public static void update() throws SQLException {
//        Connection connection = null;
//        Statement stmt = null;
//        String query = "update users set name = 'Jason'";
//
//        try {
//            connection = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "chuchko123");
//
//            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//            stmt.executeUpdate(query);
//
////            ResultSet rs = stmt.executeQuery(query);
////            while (rs.next()) {
////                String name = rs.getString("name");
////                rs.updateString("name", "Jason");
////                rs.updateRow();
////            }
//
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return;
//        } finally {
//            connection.close();
//        }
//    }
//
//    public static void insert() throws SQLException {
//        Connection connection = null;
//        Statement stmt = null;
//        String query = "select * from users";
//
//        try {
//            connection = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "chuchko123");
//
//            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = stmt.executeQuery(query);
//
//            rs.moveToInsertRow();
//            rs.updateString("name", "Brad");
//            rs.updateString("surname", "Pitt");
//            rs.updateString("email", "Brad@mail.ru");
//            rs.insertRow();
//
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return;
//        } finally {
//            connection.close();
//        }
//    }
//}
