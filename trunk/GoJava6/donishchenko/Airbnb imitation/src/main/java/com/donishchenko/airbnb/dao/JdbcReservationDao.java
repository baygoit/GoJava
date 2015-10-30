package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.jdbc.DBUtils;
import com.donishchenko.airbnb.jdbc.QueryBuilder;
import com.donishchenko.airbnb.model.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class JdbcReservationDao implements ReservationDao {
    public static final Logger log = LogManager.getLogger(JdbcReservationDao.class.getName());

    private static final String saveReservationQuery =
            "INSERT INTO reservation VALUES(null, ?, ?, ?, ?, ?)";

    private static final String deleteReservationQuery =
            "DELETE FROM reservation WHERE id = ?";

    private static final String getReservationByIdQuery =
            "SELECT * FROM reservation WHERE id = ?";

    private static final String getAllReservationsQuery =
            "SELECT * FROM reservation";

    private static final String updateReservationQuery =
            "UPDATE reservation SET userId = ?, apartmentId = ?, start = ?, end = ?, comment = ? WHERE id = ?";

    //TODO test
    private static final String getAllFreeAppartments =
            "SELECT\n" +
                    "\tap.id\n" +
                    "FROM\n" +
                    "\tapartment AS ap\n" +
                    "\tLEFT JOIN reservation AS res\n" +
                    "\tON ap.id = res.apartmentId AND\n" +
                    "\t('2015-1-1' >= res.end OR\n" +
                    "        '2015-1-3' <= res.start)\n" +
                    "WHERE\n" +
                    "\tap.city = 'Kiev' AND\n" +
                    "\tap.type = 0";

    @Override
    public int save(Reservation reservation) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(saveReservationQuery, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, reservation.getUserId());
            stat.setInt(2, reservation.getApartmenId());
            stat.setObject(3, reservation.getStart());
            stat.setObject(4, reservation.getEnd());
            stat.setString(5, reservation.getComment());

            stat.executeUpdate();

            ResultSet keys = stat.getGeneratedKeys();
            keys.next();
            reservation.setId(keys.getInt(1));

            return reservation.getId();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteReservationQuery);
            stat.setInt(1, id);

            int affectedRows = stat.executeUpdate();

            return affectedRows != 0;
        }
    }

    @Override
    public boolean update(int id, Reservation reservation) throws SQLException {
        Reservation existingReservation = get(id);
        if (existingReservation == null) {
            throw new SQLException("Wrong id");
        }

        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(updateReservationQuery);
            stat.setInt(1, reservation.getUserId());
            stat.setInt(2, reservation.getApartmenId());
            stat.setObject(3, reservation.getStart());
            stat.setObject(4, reservation.getEnd());
            stat.setString(5, reservation.getComment());
            stat.setInt(6, id);

            int affectedRows = stat.executeUpdate();

            return affectedRows != 0;
        }
    }

    @Override
    public Reservation get(int id) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(getReservationByIdQuery);
            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            result.next();

            return createReservation(result);
        }
    }

    @Override
    public List<Reservation> getAll() throws SQLException {
        return getAllReservationsWithParameters();
    }

    @Override
    public List<Reservation> getAllByApartment(int apartmentId) throws SQLException {
        return getAllReservationsWithParameters("apartmentId", Integer.toString(apartmentId));
    }

    @Override
    public List<Reservation> getAllByUser(int userId) throws SQLException {
        return getAllReservationsWithParameters("userId", Integer.toString(userId));
    }

    @Override
    public List<Reservation> getAllByHost(int userId) throws SQLException {
        //TODO list of reservations of host's apartments
        return null;
    }

    @Override
    public List<Reservation> getAllBetweenDates(Date start, Date end) throws SQLException {
        return getAllReservationsWithParameters("start", start, "end", end);
    }

    private List<Reservation> getAllReservationsWithParameters(Object...args) throws SQLException {
        QueryBuilder queryBuilder = new QueryBuilder(getAllReservationsQuery);
        queryBuilder.parse(args);

        try (Connection conn = DBUtils.getConnection()) {
            List<Reservation> list = new LinkedList<>();

            String query = queryBuilder.getQuery();
            PreparedStatement stat = conn.prepareStatement(query);
            int i = 1;
            for (Object value : queryBuilder.values()) {
                stat.setObject(i, value);
            }

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                list.add(createReservation(result));
            }

            return list;
        }
    }

    private Reservation createReservation(ResultSet result) throws SQLException {
        int id          = result.getInt(1);
        int userId      = result.getInt(2);
        int apartmentId = result.getInt(3);
        Date start      = (Date) result.getObject(4);
        Date end        = (Date) result.getObject(5);
        String comment  = result.getString(6);

        Reservation reservation = new Reservation(userId, apartmentId, start, end, comment);
        reservation.setId(id);

        return reservation;
    }
}
