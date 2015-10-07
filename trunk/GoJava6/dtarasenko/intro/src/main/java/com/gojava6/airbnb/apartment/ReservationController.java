package com.gojava6.airbnb.apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gojava6.airbnb.application.JDBC.*;

public class ReservationController {

    public void createReservation(int apartmentId, int userId, Date start, Date end) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                String sql = "INSERT INTO reservation VALUES (null, "
                        + apartmentId + ", "
                        + userId + ", "
                        + start.getTime() + ", "
                        + end.getTime() + ")";

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

    public void updateReservationDates(int reservation_id, Date start, Date end) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                String sql = "UPDATE reservation SET start = "
                        + start.getTime() + ", end = "
                        + end.getTime() + " WHERE reservation_id = "
                        + reservation_id;

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

    public void deleteReservation(int reservationId) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                String sql = "DELETE FROM reservation WHERE reservation_id = " + reservationId;
                stmt.executeUpdate(sql);
                System.out.println("Reservation (ID=" + reservationId + ") is deleted");
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

    public List<Reservation> getReservationList() {
        List<Reservation> reservationList = new ArrayList<Reservation>();

        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM reservation";
                rs = stmt.executeQuery(sql);

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

        return reservationList;
    }

    public void showAllReservations() {
        List<Reservation> reservationList = getReservationList();

        for (Reservation reservation : reservationList) {
            System.out.println(reservation.toString());
        }
    }

    public List<Reservation> getReservationListOfApartment(int apartment_Id) {
        List<Reservation> reservationList = new ArrayList<Reservation>();

        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM reservation WHERE apartment_id = " + apartment_Id;
                rs = stmt.executeQuery(sql);

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

        return reservationList;
    }

}
