package dao;


import models.Apartment;
import models.ApartmentType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2015.
 */
public class ApartmentDAO extends AbstractDAO{

    public void createApartment (Apartment apartment) {
        String sqlQuery = "INSERT INTO `airbnb`.`apartments` (`host_id`, `type`, `city`) VALUES ('"+
                apartment.getHost()+"`, `"+
                apartment.getApartmentType()+"`, `"+
                apartment.getCity()+");";
        updateDB(sqlQuery);
    }

    public void updateApartmentByID (Apartment apartment) {
        String sqlQuery = "UPDATE airbnb.apartments SET " +
                "type = '"+ apartment.getApartmentType() +
                "WHERE idapartment = "+ apartment.getApartmentId();
        updateDB(sqlQuery);
    }

    public List<Apartment> getApartments () {
        return (List<Apartment>)(List<?>)readDB("SELECT * FROM apartments");
    }

    public void deleteApartmentByID (Apartment apartment) {
        String sqlQuery = "DELETE FROM apartments WHERE idaparment = "+apartment.getApartmentId();
        updateDB(sqlQuery);
    }

    public Apartment getApartmentByID (Apartment apartment) {
        String sqlQuery = "SELECT * FROM apartments WHERE idapartment =" + apartment.getApartmentId();
        List<Apartment> apartmentsList = (List<Apartment>)(List<?>) readDB(sqlQuery);
        return apartmentsList.get(0);
    }

    @Override
    Object readObj(ResultSet resultSet) throws SQLException {
        Apartment result = null; /*new Apartment(resultSet.getInt("idapartments"),
                                         resultSet.getInt("host_id"),
                                         ApartmentType.valueOf(resultSet.getString("type")),
                                         resultSet.getString("address"),
                                         resultSet.getInt("city_id"));*/
        return result;
    }
}
