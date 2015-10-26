package com.gojava6.airbnb.dao.jdbcPstmt;


import com.gojava6.airbnb.dao.IApartmentDao;
import com.gojava6.airbnb.model.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDaoPstmt extends AbstractDaoPstmt implements IApartmentDao {

    public void createApartment(Apartment apartment) {
        String sqlCode = "INSERT INTO apartment VALUES (NULL, ?, ?, ?)";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setString(1, apartment.getCity());
            pstmt.setString(2, apartment.getApartmentType());
            pstmt.setInt(3, apartment.getUserId());
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

    public void updateApartment(Apartment apartment) {
        String sqlCode = "UPDATE apartment SET city = ?, apartment_type = ?, user_id = ? WHERE apartment_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setString(1, apartment.getCity());
            pstmt.setString(2, apartment.getApartmentType());
            pstmt.setInt(3, apartment.getUserId());
            pstmt.setInt(4, apartment.getApartmentId());
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

    public void deleteApartment(Apartment apartment) {
        String sqlCode = "DELETE FROM apartment WHERE apartment_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, apartment.getApartmentId());
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

    public List<Apartment> getApartmentList() {
        List<Apartment> apartmentList = new ArrayList<Apartment>();
        String sqlCode = "SELECT * FROM apartment";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            ResultSet rs = pstmt.executeQuery();

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
        return apartmentList;
    }

    public Apartment getApartment(Integer apartment_id) {
        Apartment apartment = null;
        String sqlCode = "SELECT * FROM apartment WHERE apartment_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, apartment_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int apartmentId = rs.getInt("apartment_id");
                String city = rs.getString("city");
                String apartmentType = rs.getString("apartment_type");
                int userId = rs.getInt("user_id");

                apartment = new Apartment();
                apartment.setApartmentId(apartmentId);
                apartment.setCity(city);
                apartment.setApartmentType(apartmentType);
                apartment.setUserId(userId);
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
        return apartment;
    }
}
