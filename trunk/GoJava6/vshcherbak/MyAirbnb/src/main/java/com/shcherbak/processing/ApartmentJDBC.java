package com.shcherbak.processing;

import com.shcherbak.model.Apartment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApartmentJDBC {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private static List<String> cities = new ArrayList<>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create( Integer owner, String city, String street, Integer house,
                        Integer room, String rent, Date ts, String comments) {
        String SQL = "insert into apartments values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update( SQL, new Object[]{null, owner, city, street, house,
                room, rent, ts, comments});
        //System.out.println("Created Record Name = " + firstname);
    }

    public Apartment getAppartment(Integer id) {
        String SQL = "select * from apartments where id = ?";
        Apartment apartment = (Apartment)jdbcTemplate.queryForObject(SQL,
                new Object[]{id}, new ApartmentMapper());
        return apartment;
    }

    public Integer getApatrmentID(String field, String value) {
        String SQL = "select id from apartments where " + field + " = " + value ;
        //String SQL = "select id from users where email = 'marlow@site.com'";
        return jdbcTemplate.queryForInt(SQL);

    }

    public List<Apartment> getApartmentByField(String field, String value) {
        String SQL = "select * from apartments where " + field + " = " + value ;
        return jdbcTemplate.query(SQL, new ApartmentMapper());
    }

    public List<Apartment> listApartments() {
        String SQL = "select * from apartments";
        List<Apartment> apartments = jdbcTemplate.query(SQL,
                new ApartmentMapper());
        return apartments;
    }

    public List<String> getCities() {
        String SQL = "select DISTINCT city from apartments";
        cities = jdbcTemplate.queryForList(SQL, String.class);
        return cities;
    }

    public void delete(Integer id){
        String SQL = "delete from apartments where id = ?";
        jdbcTemplate.update(SQL, new Object[]{id});
        //System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Integer id, Integer owner){
        String SQL = "update apartments set owner = ? where id = ?";
        jdbcTemplate.update(SQL, new Object[]{ owner, id});
        //System.out.println("Updated Record with ID = " + id );
        return;
    }
}
