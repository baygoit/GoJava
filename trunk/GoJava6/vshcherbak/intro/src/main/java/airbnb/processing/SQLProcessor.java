package airbnb.processing;

import airbnb.common.Processor;
import airbnb.model.*;
import java.util.Date;

import java.sql.*;

public class SQLProcessor implements Processor {
    private Connection connection = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private String query;
    private ResultSet rs;
    private String url;
    private String user;
    private String password;
    private String addUserQuery = "INSERT INTO users VALUES(0,?,?,?,?,?,?);";
    private String removeUserQuery = "DELETE FROM users WHERE user_id = ? ;";
    private String addApartmentQuery = "INSERT INTO apartment VALUES (0,?,?,?,?,?,?,?,?);";
    private String removeApartmentQuery = "DELETE FROM apartment WHERE apartment_id = ? ;";

    public SQLProcessor(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;

       /* try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
            //return;
        }*/
    }

    private static Timestamp getCurrentTimeStamp() {
        Date today = new Date();
        return new Timestamp(today.getTime());

    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void openDataBase() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return;
    }
    public void closeDataBase() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection don't want close!");
        }

    }
    public void addUser(User user) {
        //openDataBase();
        String userType;
        if (user.getType() == UserType.CLIENT) {
            userType = "client";
        } else {
            userType = "host";
        }
        try {
            pstmt = connection.prepareStatement(addUserQuery);
            pstmt.setString(1, userType);
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getSurname());
            pstmt.setString(4, user.getEmail());
            pstmt.setBoolean(5, user.getNotify());
            pstmt.setTimestamp(6, getCurrentTimeStamp());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //delivery.addToNotify(user);
    }
    public void removeUser(int user_id) {

        //System.out.println(query);

        try {
            pstmt = connection.prepareStatement(removeUserQuery);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void addApartment(Apartment apartment) {
        query = "INSERT INTO apartment VALUES "
                +"(0,"+apartment.getHostID()+",'"
                +apartment.getAdress().getCity()+"','"
                +apartment.getAdress().getStreet()+"',"
                +apartment.getAdress().getHouse()+","
                +apartment.getAdress().getRoom()+", '"
                +apartment.getRent()+"', CURRENT_TIMESTAMP, null);";
        //System.out.println(query);

        String apartmentType;
        if (apartment.getRent() == RentType.APARTMENT) {
            apartmentType = "apartment";
        } else if (apartment.getRent() == RentType.ROOM) {
            apartmentType = "room";
        } else {
            apartmentType = "place";
        }
        try {
            pstmt = connection.prepareStatement(addApartmentQuery);
            pstmt.setInt(1, apartment.getHostID());
            pstmt.setString(2, apartment.getAdress().getCity());
            pstmt.setString(3, apartment.getAdress().getStreet());
            pstmt.setInt(4, apartment.getAdress().getHouse());
            pstmt.setInt(5, apartment.getAdress().getRoom());
            pstmt.setString(6, apartmentType);
            pstmt.setTimestamp(7, getCurrentTimeStamp());
            pstmt.setString(6, "null");

            pstmt.executeUpdate();

        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void removeApartment(int apartment_id) {
        try {
            pstmt = connection.prepareStatement(removeApartmentQuery);
            pstmt.setInt(1, apartment_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getUsers() {
        query = "select * from users;";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String type = rs.getString("kind");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Boolean notify = rs.getBoolean("notify");
                Date ts = rs.getTimestamp("ts");
                System.out.println(user_id + " " + type + ' ' + name + " " + surname + ' ' + notify + ' ' + ts);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getApartments() {
        query = "select * from apartment;";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int apartment_id = rs.getInt("apartment_id");
                int owner = rs.getInt("owner");
                String city = rs.getString("city");
                String street = rs.getString("street");
                int house = rs.getInt("house");
                int room = rs.getInt("room");
                String rent = rs.getString("rent");
                Date ts = rs.getTimestamp("ts");
                String comments = rs.getString("comments");
                System.out.println(apartment_id + " " + owner + ' ' + city + " " + street + ' ' + house
                        + ' ' + room + ' ' + rent + ' ' + ts + ' ' + comments);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}


