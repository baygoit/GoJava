package main.java.DAO;

import main.java.Models.Apartment;
import main.java.Models.Reservation;
import main.java.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 29.10.2015.
 */
public class ReservationDAO extends AbstractDAO{
    public void createReservation ( Reservation reservation) {
        String sqlQuery = "INSERT INTO `airbnb`.`reservations` (`idapartment`, `start`, `finish` , 'client_id') VALUES ('"+
                reservation.getApartmentId()+"`, `"+
                reservation.getStart()+"`, `"+
                reservation.getFinish()+"`, `"+
                reservation.getClientId()+");";
        updateDB(sqlQuery);
    }

    public void updateReservationByID (Reservation reservation) {
        String sqlQuery = "UPDATE airbnb.reservations SET " +
                "start = '"+ reservation.getStart() +
                "finish = '"+ reservation.getFinish() +
                "WHERE reserv_id = "+ reservation.getReservId();
        updateDB(sqlQuery);
    }

    public List<Reservation> getReservations () {
        return (List<Reservation>)(List<?>)readDB("SELECT * FROM reservations");
    }

    public void deleteReservationByID (Reservation reservation) {
        String sqlQuery = "DELETE FROM apartments WHERE reserv_id = "+reservation.getReservId();
        updateDB(sqlQuery);
    }

    public Apartment getApartmentByID (Apartment apartment) {
        String sqlQuery = "SELECT * FROM apartments WHERE reserv_id =" + apartment.getApartmentId();
        List<Apartment> apartmentsList = (List<Apartment>)(List<?>) readDB(sqlQuery);
        return apartmentsList.get(0);
    }

    @Override
    Reservation readObj(ResultSet resultSet) throws SQLException {
        Reservation result = new Reservation(resultSet.getInt("reserv_id"),
                    resultSet.getInt("idapartment"),
                    resultSet.getDate("start"),
                    resultSet.getDate("finish"),
                    resultSet.getInt("clientId"));
        return result;
    }
}