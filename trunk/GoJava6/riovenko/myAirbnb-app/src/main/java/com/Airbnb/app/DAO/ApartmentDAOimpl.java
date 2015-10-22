package com.Airbnb.app.DAO;

import com.Airbnb.app.jdbc.DBConnection;
import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;

/**
 * Created by romanroma on 10.10.15.
 */
public class ApartmentDAOimpl implements ApartmentDAO {

    private String addApartmentQuery =
            "INSERT INTO apartment (userId, cityId, apartmentTypeId) VALUES (?, ?, ?)";
    private String deleteApartmentQuery =
            "DELETE FROM apartment WHERE idApartment = ?";
    private String getApartmentByIdQuery =
            "SELECT apt.idApartment, apt.userId, apt.cityId, city.name, apt.apartmentTypeId, " +
                    "apartmentType.apartmentType FROM apartment apt JOIN city ON (apt.cityId = idCity) " +
                    "JOIN apartmentType ON (apt.apartmentTypeId = idApartmentType) WHERE idApartment = ?";
    private String checkUniqueCityQuery =
            "SELECT COUNT(*) FROM city WHERE name = ? ";
    private String addUniqueCityQuery =
            "INSERT INTO city (name) VALUES (?)";
    private String getCityIdQuery =
            "SELECT idCity FROM city WHERE name = ?";
    private String getApartmentTypeIdQuery =
            "SELECT idApartmentType FROM apartmentType WHERE apartmentType = ?";
    private String getAllApartmentQuery = "SELECT apt.idApartment, apt.userId, apt.cityId, city.name, " +
            "apt.apartmentTypeId, apartmentType.apartmentType FROM apartment apt JOIN city ON (apt.cityId = idCity) " +
            "JOIN apartmentType ON (apt.apartmentTypeId = idApartmentType)";
    private String getPossibleApartmentQuerry = "SELECT idApartment FROM apartment WHERE cityId = ?," +
            "apartmentTypeId = ?";
    private String checkExistingApartment =
            "SELECT COUNT(*) FROM apartment WHERE userId = ? and cityId = ? and apartmentTypeId = ?";

    public void addApartment (Apartment apartment) throws SQLException{
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(addApartmentQuery);
            psttmnt.setInt(1, apartment.getHost());
            psttmnt.setInt(2, getCityId(apartment.getCity()));
            psttmnt.setInt(3, getApartmentTypeId(apartment.getApartType()));
            psttmnt.executeUpdate();
        }
    }

    public void deleteApartment (int id)throws SQLException{
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(deleteApartmentQuery);
            psttmnt.setInt(1, id);
            psttmnt.executeUpdate();
        }
    }

    public Apartment getApartmentById (int id) throws SQLException{
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(getApartmentByIdQuery);
            psttmnt.setInt(1, id);

            ResultSet result = psttmnt.executeQuery();
            result.next();

            Apartment apartment = new Apartment(result.getInt(2),result.getString(4),
                    ApartType.getApartType(result.getString(6)));
            apartment.setId(result.getInt(1));

            return apartment;
        }
    }

    public int checkUniqueCity (String city) throws SQLException {
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(checkUniqueCityQuery);
            psttmnt.setString(1, city);

            ResultSet result = psttmnt.executeQuery();
            result.next();

            if(result.getInt(1) == 0){
                return addUniqueCity(city);
            }

            else{
                return getCityId(city);
            }
        }
    }

    public int addUniqueCity (String city) throws SQLException{
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement psttnmt = connection.prepareStatement(addUniqueCityQuery);
            psttnmt.setString(1, city);
            psttnmt.executeUpdate();
        }
        return getCityId(city);
    }

    public int getCityId (String city) throws SQLException{
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(getCityIdQuery);
            psttmnt.setString(1, city);

            ResultSet result = psttmnt.executeQuery();
            result.next();

            return result.getInt(1);
        }
    }

    public int getApartmentTypeId (ApartType apartmentType) throws SQLException{
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(getApartmentTypeIdQuery);
            psttmnt.setString(1, apartmentType.toString());

            ResultSet result = psttmnt.executeQuery();
            result.next();

            return result.getInt(1);
        }
    }

    public List<Apartment> getAllApartment () throws SQLException{
        try(Connection connection = DBConnection.getConnection()){
            List<Apartment> apartmentList = new LinkedList<>();
            PreparedStatement psttmnt = connection.prepareStatement(getAllApartmentQuery);

            ResultSet result = psttmnt.executeQuery();
            while (result.next()){
                Apartment apartment = new Apartment(result.getInt(2),result.getString(4),
                        ApartType.getApartType(result.getString(6)));
                apartment.setId(result.getInt(1));
                apartmentList.add(apartment);
            }

            return apartmentList;
        }
    }

    public int checkExistingApartment (int userId, String city, ApartType apartType) throws SQLException {
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(checkExistingApartment);
            psttmnt.setInt(1, userId);
            psttmnt.setInt(2, getCityId(city));
            psttmnt.setInt(3, getApartmentTypeId(apartType));

            ResultSet result = psttmnt.executeQuery();
            result.next();
            return result.getInt(1);
        }
    }
}
