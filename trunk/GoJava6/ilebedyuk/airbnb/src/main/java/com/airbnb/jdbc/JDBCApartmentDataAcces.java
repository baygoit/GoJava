package com.airbnb.jdbc;

import com.airbnb.dao.IApartmentDao;
import com.airbnb.model.Apartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public class JDBCApartmentDataAcces extends AbstractBaseDao implements IApartmentDao {
    private String sqlCode = null;

    @Override
    public List<Apartment> getApartmentList() {
        List<Apartment> apartments = new ArrayList<Apartment>();
        sqlCode = "SELECT * FROM apartaments;";
        List<Object> objects = objectsList(sqlCode);
        for (Object o : objects) {
            Apartment apartment = (Apartment) o;
            apartments.add(apartment);
        }
        return apartments;
    }

    @Override
    public Apartment getApartment(int id) {
        sqlCode = "SELECT * FROM apartaments where idapartaments = " + id + ";";
        Apartment apartment = (Apartment) objectsList(sqlCode).get(0);
        System.out.println(apartment);
        return apartment;
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete FROM apartaments where idapartaments = " + id + ";";
        updateData(sqlCode);
        System.out.println("Apartment with id = " + id + "is deleted from DB");
    }

    @Override
    public void addToDb(Apartment apartment) {
        sqlCode = "insert into apartaments values(null, '" +
                apartment.getApartmentType() + "', '" +
                apartment.getCity() + "', '" +
                apartment.getOwnerId() + "');";
        updateData(sqlCode);
        System.out.println("Apartment" + apartment.getApartmentType() + "is added to DB");
    }

    @Override
    Apartment createObject(ResultSet resultSet) {
        Apartment apartment = null;
        try {
            int apartamentId = resultSet.getInt("idapartaments");
            String type = resultSet.getString("type");
            String city = resultSet.getString("city");
            int iduser = resultSet.getInt("iduser");

            apartment = new Apartment(type, city, iduser);
            apartment.setIdAparnament(apartamentId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartment;
    }

//    public void printApartaments(){
//        List<Apartment> apartments = getApartmentList();
//        for (Apartment apartment : apartments) {
//            System.out.println(apartment.toString());
//        }
//    }

//    public static void main(String[] args) {
//        JDBCApartmentDataAcces jdbcApartmentDataAcces = new JDBCApartmentDataAcces();
//        jdbcApartmentDataAcces.printApartaments();
//    }
}
