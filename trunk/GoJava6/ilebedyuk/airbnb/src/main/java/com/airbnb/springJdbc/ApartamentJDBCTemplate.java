package com.airbnb.springJdbc;

import com.airbnb.dao.IApartmentDao;
import com.airbnb.model.Apartment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Игорь on 30.10.2015.
 */
public class ApartamentJDBCTemplate implements IApartmentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    public List<Apartment> getApartmentList() {
        String sqlCode = "SELECT * FROM apartaments;";
        List<Apartment> apartments = jdbcTemplateObject.query(sqlCode, new ApartamentMapper());
        return apartments;
    }

    public List<Apartment> getApartmentListByIdUser(int idUser) {
        String sqlCode = "SELECT apartaments.* FROM apartaments join user on user.iduser = apartaments.iduser where user.iduser = ?;";
        List<Apartment> apartments = jdbcTemplateObject.query(sqlCode, new ApartamentMapper(), idUser);
        return apartments;
    }

    public Apartment getApartment(int id) {
        String sqlCode = "SELECT * FROM apartaments where idapartaments = ?;";
        Apartment apartment = jdbcTemplateObject.queryForObject(sqlCode, new Object[]{id}, new ApartamentMapper());
        return apartment;
    }

    public void delete(int id) {
        String sqlCode = "delete FROM apartaments where idapartaments = ?;";
        jdbcTemplateObject.update(sqlCode, id);
    }

    public void addToDb(Apartment apartment) {
        String sqlCode = "insert into apartaments values(null, ?, ?, ?);";
        jdbcTemplateObject.update(sqlCode, apartment.getApartmentType(), apartment.getCity(), apartment.getOwnerId());
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        ApartamentJDBCTemplate apartamentJDBCTemplate = (ApartamentJDBCTemplate)context.getBean("apartamentJDBCTemplate");

        List<Apartment> apartments = apartamentJDBCTemplate.getApartmentListByIdUser(13);
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }
    }
}
