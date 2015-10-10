package airbnb.processing;

import airbnb.common.Processor;
import airbnb.model.Adress;
import airbnb.model.RentType;
import airbnb.model.User;
import airbnb.model.UserType;

import java.sql.*;

public class SQLProcessor implements Processor {
    private Connection connection = null;
    private Statement stmt = null;
    private String query;
    private ResultSet rs;
    private String url;
    private String user;
    private String password;

    public SQLProcessor(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
            return;
        }
    }

    private void openDataBase() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return;
    }
    private void closeDataBase() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection don't want close!");
        }

    }
    public void registerUser(User user) {
        //openDataBase();
        query = "INSERT INTO users VALUES " +
                "(0,'"+user.getType()+"','"+user.getName()+"','"+user.getSurname()+
                "','"+user.getEmail()+"', "+ true +", CURRENT_TIMESTAMP);";
        System.out.println(query);

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        //delivery.addToNotify(user);
    }
    public void removeUser(String surname) {

    }
    public void addApartment(User user, RentType rent, Adress adress) {

    }
    public void removeApartment(int id) {

    }

    public void test() {
        query = "select * from users;";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("user_id");
                String firstname = rs.getString("name");
                String lastname = rs.getString("surname");
                System.out.println("id" + id + " firstname: " + firstname + ", lastname: " + lastname);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        User user =  new User("Test", "Save", "qwer@site.com", UserType.HOST);
        SQLProcessor processor =
                new SQLProcessor("jdbc:mysql://localhost:3306/airbnb", "root", "atmel");
        processor.openDataBase();
        processor.registerUser(user);
        processor.test();
        processor.closeDataBase();
    }
}


