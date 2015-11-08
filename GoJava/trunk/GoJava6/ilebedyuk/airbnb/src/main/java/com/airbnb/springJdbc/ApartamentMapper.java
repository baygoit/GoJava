package com.airbnb.springJdbc;

import com.airbnb.model.Apartment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Игорь on 29.10.2015.
 */
public class ApartamentMapper implements RowMapper<Apartment> {
    public Apartment mapRow(ResultSet resultSet, int i) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setIdAparnament(resultSet.getInt("idapartaments"));
        apartment.setApartmentType(resultSet.getString("type"));
        apartment.setCity(resultSet.getString("city"));
        apartment.setOwnerId(resultSet.getInt("iduser"));
        return apartment;
    }
}
