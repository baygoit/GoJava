package com.shcherbak.processing;

import com.shcherbak.accounting.ReservationDates;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public class ReservationJDBC {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create( Integer apartment, Integer client, Date start, Date end,
                         Date ts, String comments) {
        String SQL = "insert into reservations values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update( SQL, new Object[]{null, apartment, client, start, end,
                ts, comments});
        //System.out.println("Created Record Name = " + firstname);
    }

    public ReservationDates getReservation(Integer id) {
        String SQL = "select * from reservations where id = ?";
        ReservationDates dates = (ReservationDates)jdbcTemplate.queryForObject(SQL,
                new Object[]{id}, new ReservationMapper());
        return dates;
    }

    public List<ReservationDates> listReservations() {
        String SQL = "select * from reservations";
        List<ReservationDates> reservationDates = jdbcTemplate.query(SQL,
                new ReservationMapper());
        return reservationDates;
    }

    public List<Integer> getReservationsByDates( Date end, Date start) {
        String SQL = "select apartment_id from reservations where start < ? AND end > ?";
        List<Integer> apartmentsID = jdbcTemplate.queryForList(SQL, new Object[]{start, end}, java.lang.Integer.class);
        return apartmentsID;
    }

    public void delete(Integer id){
        String SQL = "delete from reservations where id = ?";
        jdbcTemplate.update(SQL, new Object[]{id});
        //System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Integer id, Integer client){
        String SQL = "update reservations set client_id = ? where id = ?";
        jdbcTemplate.update(SQL, new Object[]{ client, id});
        //System.out.println("Updated Record with ID = " + id );
        return;
    }
}
