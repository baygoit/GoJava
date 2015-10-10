package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.Apartment;
import com.gojava6.airbnb.model.ApartmentType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ApartmentDao extends AbstractDao {

    public void createApartment(String city, ApartmentType apartmentType, Integer userId) {
        String sqlCode = "INSERT INTO apartment VALUES (null, '"
                + city + "', '"
                + apartmentType.getApartmentType() + "', '"
                + userId + "')";
        updateDatabase(sqlCode);
    }

    public void deleteApartment(Integer apartmentId) {
        String sqlCode = "DELETE FROM apartment WHERE apartment_id = " + apartmentId;
        updateDatabase(sqlCode);
    }

    public List<Object> getApartmentList() {
        String sqlCode = "SELECT * FROM apartment";
        return readDatabase(sqlCode);
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
