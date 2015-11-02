package com.airbnb.springJdbc;

import com.airbnb.dao.IReservationDao;
import com.airbnb.model.Apartment;
import com.airbnb.model.ReservationDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Игорь on 30.10.2015.
 */
public class ReservationDateJDBCTemplate implements IReservationDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<ReservationDate> getReservationDateList() {
        String sqlCode = "select * from reservationdates;";
        List<ReservationDate> reservationDates = jdbcTemplateObject.query(sqlCode, new ReservationDateMapper());
        return reservationDates;
    }

    public List<ReservationDate> getReservationDateListByIdApartament(int idApartament) {
        String sqlCode = "SELECT reservationdates.* FROM reservationdates join apartaments on apartaments.idapartaments = reservationdates.apartmentId where apartaments.idapartaments = ?;";
        List<ReservationDate> reservationDates = jdbcTemplateObject.query(sqlCode, new ReservationDateMapper(), idApartament);
        return reservationDates;
    }

    public ReservationDate getReservationDate(int id) {
        String sqlCode = "select * from reservationdates where idreservationDates = ?;";
        ReservationDate reservationDate = jdbcTemplateObject.queryForObject(sqlCode, new Object[]{id}, new ReservationDateMapper());
        return reservationDate;
    }

    public void delete(int id) {
        String sqlCode = "delete from reservationdates where idreservationDates = ?;";
        jdbcTemplateObject.update(sqlCode, id);
    }

    public void addToDb(ReservationDate reservationDate) {
        String sqlCode = "insert into reservationdates values(null, ?, ?, ?);";
        jdbcTemplateObject.update(sqlCode, reservationDate.getDateBegin(), reservationDate.getDateEnd(), reservationDate.getApartamentId());
    }

//    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("Beans.xml");
//
//        ReservationDateJDBCTemplate reservationDateJDBCTemplate = (ReservationDateJDBCTemplate)context.getBean("reservationJDBCTemplate");
//
//        List<ReservationDate> reservationDates = reservationDateJDBCTemplate.getReservationDateList();
//        for (ReservationDate reservationDate : reservationDates) {
//            System.out.println(reservationDate);
//        }
//        ReservationDate reservationDate = reservationDateJDBCTemplate.getReservationDate(2);
//        reservationDateJDBCTemplate.addToDb(reservationDate);
//    }
}
