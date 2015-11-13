package com.donishchenko.airbnb.dao.old;

import com.donishchenko.airbnb.dao.ReservationDao;
import com.donishchenko.airbnb.dbutils.JdbcUtils;
import com.donishchenko.airbnb.dbutils.QueryBuilder;
import com.donishchenko.airbnb.model.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ReservationJdbcDao implements ReservationDao {
    public static final Logger log = LogManager.getLogger(ReservationJdbcDao.class.getName());

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
    public void save(Reservation reservation) {
        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(saveReservationQuery, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, reservation.getUser().getId());
            stat.setInt(2, reservation.getApartment().getId());
            stat.setObject(3, reservation.getStart());
            stat.setObject(4, reservation.getEnd());
            stat.setString(5, reservation.getComment());

            stat.executeUpdate();

            ResultSet keys = stat.getGeneratedKeys();
            keys.next();
            reservation.setId(keys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reservation get(Integer id) {
        Reservation reservation = null;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(getReservationByIdQuery);
            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            if (result.next()) {
                reservation = createReservation(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservation;
    }

    @Override
    public boolean update(Reservation reservation) {
        boolean updated = false;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(updateReservationQuery);
            stat.setInt(1, reservation.getUser().getId());
            stat.setInt(2, reservation.getApartment().getId());
            stat.setObject(3, reservation.getStart());
            stat.setObject(4, reservation.getEnd());
            stat.setString(5, reservation.getComment());
            stat.setInt(6, reservation.getId());

            int affectedRows = stat.executeUpdate();

            updated = affectedRows != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public boolean delete(Integer id) {
        boolean updated = false;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteReservationQuery);
            stat.setInt(1, id);

            int affectedRows = stat.executeUpdate();

            updated = affectedRows != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public List<Reservation> getAll() {
        return getAllReservationsWithParameters();
    }

    @Override
    public List<Reservation> getAllByApartment(Integer apartmentId) {
        return getAllReservationsWithParameters("apartmentId", apartmentId);
    }

    @Override
    public List<Reservation> getAllByUser(Integer userId) {
        return getAllReservationsWithParameters("userId", userId);
    }

    @Override
    public List<Reservation> getAllBetweenDates(Date start, Date end) {
        return getAllReservationsWithParameters("start", start, "end", end);
    }

    private List<Reservation> getAllReservationsWithParameters(Object...args) {
        List<Reservation> list = Collections.emptyList();

        QueryBuilder queryBuilder = new QueryBuilder(getAllReservationsQuery);
        queryBuilder.parse(args);

        try (Connection conn = JdbcUtils.getConnection()) {
            list = new ArrayList<>();

            String query = queryBuilder.getQuery();
            PreparedStatement stat = conn.prepareStatement(query);

            int i = 1;
            for (Object value : queryBuilder.values()) {
                stat.setObject(i++, value);
            }

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                list.add(createReservation(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private Reservation createReservation(ResultSet result) throws SQLException {
        int id          = result.getInt(1);
        int userId      = result.getInt(2);
        int apartmentId = result.getInt(3);
        Date start      = (Date) result.getObject(4);
        Date end        = (Date) result.getObject(5);
        String comment  = result.getString(6);


        //TODO
//        Reservation reservation = new Reservation(userId, apartmentId, start, end, comment);
//        reservation.setId(id);

        return new Reservation();
    }
}
