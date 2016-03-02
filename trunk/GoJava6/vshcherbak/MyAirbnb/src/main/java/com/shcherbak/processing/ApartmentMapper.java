package com.shcherbak.processing;

import com.shcherbak.model.Apartment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentMapper implements RowMapper {
    public Apartment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setApartmentID(rs.getInt("id"));
        apartment.setHostID(rs.getInt("owner"));
        apartment.setCity(rs.getString("city"));
        apartment.setStreet(rs.getString("street"));
        apartment.setHouse(rs.getInt("house"));
        apartment.setRoom(rs.getInt("room"));
        apartment.setRent(rs.getString("rent"));
        apartment.setDate(rs.getDate("ts"));
        apartment.setComment(rs.getString("comments"));
        return apartment;
    }
}
