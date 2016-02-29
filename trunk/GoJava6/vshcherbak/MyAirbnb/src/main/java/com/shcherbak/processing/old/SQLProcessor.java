package com.shcherbak.processing.old;
/*
import com.shcherbak.accounting.ReservationDates;
import com.shcherbak.common.Processor;
import com.shcherbak.model.old.Apartment;
import com.shcherbak.model.old.User;
import com.shcherbak.model.old.Adress;
import com.shcherbak.model.old.RentType;
import com.shcherbak.model.old.UserType;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class SQLProcessor implements Processor {
    private Connection connection = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private String query;
    private ResultSet rs;
    private String url;
    private String user;
    private String password;

    public SQLProcessor(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
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
    }
    public void closeDataBase() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection don't want close!");
        }
    }
    public void addUser(User user) {
        String addUserQuery = "INSERT INTO users VALUES(0,?,?,?,?,?,?);";
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

    }
    public void removeUser(int user_id) {
        String removeUserQuery = "DELETE FROM users WHERE user_id = ? ;";
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
        String addApartmentQuery = "INSERT INTO apartments VALUES (0,?,?,?,?,?,?,?,?);";
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
            pstmt.setString(8, "null");
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void removeApartment(int apartment_id) {
        String removeApartmentQuery = "DELETE FROM apartments WHERE apartment_id = ? ;";
        try {
            pstmt = connection.prepareStatement(removeApartmentQuery);
            pstmt.setInt(1, apartment_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addReservation(int apartment_id, int client_id, Date start, Date end) {
        String addReservationQuery = "INSERT INTO reservations VALUES(0,?,?,?,?,?,?);";
        java.sql.Date startDate = new java.sql.Date(start.getTime());
        java.sql.Date endDate = new java.sql.Date(end.getTime());

        try {
            pstmt = connection.prepareStatement(addReservationQuery);
            pstmt.setInt(1, apartment_id);
            pstmt.setInt(2, client_id);
            pstmt.setDate(3, startDate);
            pstmt.setDate(4, endDate);
            pstmt.setTimestamp(5, getCurrentTimeStamp());
            pstmt.setString(6, "null");
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeReservation(int reservation_id) {
        String removeReservationQuery = "DELETE FROM reservations WHERE reservation_id = ? ;";
        try {
            pstmt = connection.prepareStatement(removeReservationQuery);
            pstmt.setInt(1, reservation_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeReservations(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String removeReservationQuery = "DELETE FROM reservations WHERE end < ? ;";
        try {
            pstmt = connection.prepareStatement(removeReservationQuery);
            pstmt.setDate(1, sqlDate);
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

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Apartment> getApartments() {
        List<Apartment> apartments = new ArrayList<>();
        String getApartmentsQuery = "select * from apartments;";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(getApartmentsQuery);

            while (rs.next()) {
                addApartmentToList(apartments);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return apartments;
    }

    public List<Apartment> getApartments(String city, RentType rent) {
        List<Apartment> apartments = new ArrayList<>();
        String getApartmentsQuery = "select * from apartments where city=? and rent=?;";
        try {
            pstmt = connection.prepareStatement(getApartmentsQuery);
            pstmt.setString(1, city);
            if (rent.equals(RentType.APARTMENT)) {
                pstmt.setString(2, "apartment");
            } else if (rent.equals(RentType.ROOM)) {
                pstmt.setString(2, "room");;
            } else {
                pstmt.setString(2, "place");
            }
            rs = pstmt.executeQuery();

            while (rs.next()) {
                addApartmentToList(apartments);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return apartments;
    }

    private void addApartmentToList(List<Apartment> apartments) throws SQLException {
        int apartment_id = rs.getInt("apartment_id");
        int owner = rs.getInt("owner");
        String city = rs.getString("city");
        String street = rs.getString("street");
        int house = rs.getInt("house");
        int room = rs.getInt("room");
        String rent = rs.getString("rent");
        Date ts = rs.getTimestamp("ts");
        String comments = rs.getString("comments");
        Adress adress = new Adress(city, street, house, room);
        if (rent.equals("apartment")) {
            RentType rentType = RentType.APARTMENT;
        } else if (rent.equals("room")) {
            RentType rentType = RentType.ROOM;
        } else {
            RentType rentType = RentType.PLACE;
        }
        RentType rentType = RentType.APARTMENT;
        apartments.add(new Apartment(owner, rentType, adress));
    }

    public List<Apartment> search( String city, RentType rent, Date startString, Date endString ) throws ParseException {
        List<Apartment> apartments;
        List<ReservationDates> reservationDates;
        apartments = getApartments(city, rent);

        reservationDates = getReservations(startString, endString);

        ListIterator<Apartment> aIt = apartments.listIterator();
        while (aIt.hasNext()) {
            Apartment apartment = aIt.next();
            for (ReservationDates reserv: reservationDates) {
                if (reserv.getApartmentId() == apartment.getApartmentID()) {
                    aIt.remove();
                }
            }
        }
        return apartments;
    }

    public List<ReservationDates> getReservations() {
        List<ReservationDates> reservationDates = new ArrayList<>();
        query = "select * from reservations;";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                addReservationToList(reservationDates);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return reservationDates;
    }

    public List<ReservationDates> getReservations(Date start, Date end){
        List<ReservationDates> reservationDates = new ArrayList<>();
        String getReservationQuery = "SELECT * FROM reservations WHERE start < ? and end > ? ;";
        java.sql.Date startDate = new java.sql.Date(start.getTime());
        java.sql.Date endDate = new java.sql.Date(end.getTime());
        try {
            pstmt = connection.prepareStatement(getReservationQuery);
            pstmt.setDate(1, endDate);
            pstmt.setDate(2, startDate);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                addReservationToList(reservationDates);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return reservationDates;
    }

    private void addReservationToList(List<ReservationDates> reservationDates) throws SQLException {
        int reservation_id = rs.getInt("reservation_id");
        int apartment_id = rs.getInt("apartment_id");
        int client_id = rs.getInt("client_id");
        Date getStart = rs.getDate("start");
        Date getEnd = rs.getDate("end");
        Date ts = rs.getTimestamp("ts");
        String comments = rs.getString("comments");
        reservationDates.add(new ReservationDates(apartment_id, client_id, getStart, getEnd));
    }

    public void setNotify (int user_id) {
        String setNotifyQuery = "UPDATE users SET notify = true WHERE user_id = ? ;";
        try {
            pstmt = connection.prepareStatement(setNotifyQuery);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void unSetNotify (int user_id) {
        String unSetNotifyQuery = "UPDATE users SET notify = false WHERE user_id = ? ;";
        try {
            pstmt = connection.prepareStatement(unSetNotifyQuery);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<String> getNotifyEmails(String kind) {
        List<String> emails = new ArrayList<>();
        if (kind.equals("All")) {
            query = "SELECT email FROM users;";
            getEmail(emails,query);
        } else if (kind.equals("notify")) {
            query = "SELECT email FROM users WHERE notify = true;";
            getEmail(emails,query);
        } else if (kind.equals("host")) {
            query = "SELECT email FROM users WHERE kind = 'host';";
            getEmail(emails,query);
        } else if (kind.equals("client")) {
            query = "SELECT email FROM users WHERE kind = 'client';";
            getEmail(emails,query);
        }
        return emails;
    }

    private void getEmail (List<String> emails, String getEmailQuery) {
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String email = rs.getString("email");
                emails.add(email);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
*/