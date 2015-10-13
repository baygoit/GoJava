package com.gojava6.airbnb.dao.jdbc;

import com.gojava6.airbnb.dao.IApartmentDao;
import com.gojava6.airbnb.model.Apartment;
import com.gojava6.airbnb.model.ApartmentType;
import com.gojava6.airbnb.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ApartmentDao extends AbstractDao implements IApartmentDao {

    public void createApartment(Apartment apartment) {
        String sqlCode = "INSERT INTO apartment VALUES (null, '" +
                apartment.getCity() + "', '" +
                apartment.getApartmentType() + "', '" +
                apartment.getUserId() + "')";
        updateDatabase(sqlCode);
    }

    public void updateApartment(Apartment apartment) {
        String sqlCode = "UPDATE apartment SET city = '" +
                apartment.getCity() + "', apartment_type = '" +
                apartment.getApartmentType() + "' WHERE apartment_id = " +
                apartment.getApartmentId();
        updateDatabase(sqlCode);
    }

    public void deleteApartment(Apartment apartment) {
        String sqlCode = "DELETE FROM apartment WHERE apartment_id = " + apartment.getApartmentId();
        updateDatabase(sqlCode);
    }

    public List<Apartment> getApartmentList() {
        String sqlCode = "SELECT * FROM apartment";
        return (List<Apartment>)(List<?>) readDatabase(sqlCode);
    }

    public Apartment getApartment (Integer apartmentId) {
        String sqlCode = "SELECT * FROM apartment WHERE apartment_id =" + apartmentId;
        List<Apartment> apartmentList = (List<Apartment>)(List<?>) readDatabase(sqlCode);
        return apartmentList.get(0);
    }

    @Override
    Apartment createObject(ResultSet resultSet) throws SQLException {
        int apartmentId = resultSet.getInt("apartment_id");
        String city = resultSet.getString("city");
        String apartmentType = resultSet.getString("apartment_type");
        int userId = resultSet.getInt("user_id");

        Apartment apartment = new Apartment();
        apartment.setApartmentId(apartmentId);
        apartment.setCity(city);
        apartment.setApartmentType(apartmentType);
        apartment.setUserId(userId);

        return apartment;
    }

}
