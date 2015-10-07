package com.gojava6.airbnb.apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.gojava6.airbnb.application.JDBC.*;

public class ApartmentController {

    public void createApartment(String city, ApartmentType apartmentType, Integer userId) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                String sql = "INSERT INTO apartment VALUES (null, '"
                        + city + "', '"
                        + apartmentType.getApartmentType() + "', '"
                        + userId + "')";

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

    public void deleteApartment(Integer apartmentId) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                String sql = "DELETE FROM apartment WHERE apartment_id = " + apartmentId;
                stmt.executeUpdate(sql);
                System.out.println("Apartment (ID=" + apartmentId + ") is deleted");
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

    public List<Apartment> getApartmentList() {
        List<Apartment> apartmentList = new ArrayList<Apartment>();

        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM apartment";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int apartmentId = rs.getInt("apartment_id");
                    String city = rs.getString("city");
                    String apartmentType = rs.getString("apartment_type");
                    int userId = rs.getInt("user_id");

                    Apartment apartment = new Apartment();
                    apartment.setApartmentId(apartmentId);
                    apartment.setCity(city);
                    apartment.setApartmentType(apartmentType);
                    apartment.setUserId(userId);

                    apartmentList.add(apartment);
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

        return apartmentList;
    }

    public void showAllApartments() {
        List<Apartment> apartmentList = getApartmentList();

        for (Apartment apartment : apartmentList) {
            System.out.println(apartment.toString());
        }
    }
}
