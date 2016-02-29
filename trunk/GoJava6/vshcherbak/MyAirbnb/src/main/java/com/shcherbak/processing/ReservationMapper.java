package com.shcherbak.processing;

import com.shcherbak.accounting.ReservationDates;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapper implements RowMapper{
    public ReservationDates mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReservationDates dates = new ReservationDates();
        dates.setApartment_id(rs.getInt("apartment_id"));
        dates.setClient_id(rs.getInt("client_id"));
        dates.setStart(rs.getDate("start"));
        dates.setEnd(rs.getDate("end"));
        dates.setDate(rs.getDate("ts"));
        dates.setComments(rs.getString("comments"));
        return dates;
    }
}
