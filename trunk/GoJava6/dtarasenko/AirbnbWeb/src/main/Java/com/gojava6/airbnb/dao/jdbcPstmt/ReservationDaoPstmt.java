package com.gojava6.airbnb.dao.jdbcPstmt;


import com.gojava6.airbnb.dao.IReservationDao;
import com.gojava6.airbnb.model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoPstmt extends AbstractDaoPstmt implements IReservationDao {

    public void createReservation(Reservation reservation) {
        String sqlCode = "INSERT INTO reservation VALUES (NULL, ?, ?, ?, ?)";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, reservation.getApartmentId());
            pstmt.setInt(2, reservation.getUserId());
            pstmt.setLong(3, reservation.getStart());
            pstmt.setLong(4, reservation.getEnd());
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

    public void updateReservation(Reservation reservation) {
        String sqlCode = "UPDATE reservation SET apartment_id = ?, user_id = ?, start = ?, end = ? WHERE reservation_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, reservation.getApartmentId());
            pstmt.setInt(2, reservation.getUserId());
            pstmt.setLong(3, reservation.getStart());
            pstmt.setLong(4, reservation.getEnd());
            pstmt.setInt(5, reservation.getReservationId());
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

    public void deleteReservation(Reservation reservation) {
        String sqlCode = "DELETE FROM reservation WHERE reservation_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, reservation.getReservationId());
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

    public List<Reservation> getReservationList() {
        List<Reservation> reservationList = new ArrayList<Reservation>();
        String sqlCode = "SELECT * FROM reservation";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sqlCode);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                int apartmentId = rs.getInt("apartment_id");
                int userId = rs.getInt("user_id");
                long start = rs.getLong("start");
                long end = rs.getLong("end");

                Reservation reservation = new Reservation();
                reservation.setReservationId(reservationId);
                reservation.setApartmentId(apartmentId);
                reservation.setUserId(userId);
                reservation.setStart(start);
                reservation.setEnd(end);

                reservationList.add(reservation);
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
        return reservationList;
    }

    public List<Reservation> getApartmentReservationList(Integer apartment_id) {
        List<Reservation> reservationList = new ArrayList<Reservation>();
        String sqlCode = "SELECT * FROM reservation WHERE apartment_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, apartment_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                int apartmentId = rs.getInt("apartment_id");
                int userId = rs.getInt("user_id");
                long start = rs.getLong("start");
                long end = rs.getLong("end");

                Reservation reservation = new Reservation();
                reservation.setReservationId(reservationId);
                reservation.setApartmentId(apartmentId);
                reservation.setUserId(userId);
                reservation.setStart(start);
                reservation.setEnd(end);

                reservationList.add(reservation);
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
        return reservationList;
    }

    public Reservation getReservation(Integer reservation_id) {
        Reservation reservation = null;
        String sqlCode = "SELECT * FROM reservation WHERE reservation_id = ?";
        Connection conn = getDBConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sqlCode);
            pstmt.setInt(1, reservation_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                int apartmentId = rs.getInt("apartment_id");
                int userId = rs.getInt("user_id");
                long start = rs.getLong("start");
                long end = rs.getLong("end");

                reservation = new Reservation();
                reservation.setReservationId(reservationId);
                reservation.setApartmentId(apartmentId);
                reservation.setUserId(userId);
                reservation.setStart(start);
                reservation.setEnd(end);
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
        return reservation;
    }
}
