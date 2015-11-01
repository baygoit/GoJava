package com.airbnb.jdbcPrep;

import com.airbnb.dao.IApartmentDao;
import com.airbnb.jdbcPrep.AbstractBaseDao;
import com.airbnb.model.Apartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public class JDBCApartmentDataAcces extends AbstractBaseDao implements IApartmentDao {
    private String sqlCode;

    @Override
    public List<Apartment> getApartmentList() {
        List<Apartment> apartments = new ArrayList<Apartment>();
        sqlCode = "SELECT * FROM apartaments;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            List<Object> objects = objectsList();
            for (Object o : objects) {
                Apartment apartment = (Apartment) o;
                apartments.add(apartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return apartments;
    }

    @Override
    public List<Apartment> getApartmentListByIdUser(int idUser) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        sqlCode = "SELECT apartaments.* FROM apartaments join user on user.iduser = apartaments.iduser where user.iduser = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, idUser);
            List<Object> objects = objectsList();
            for (Object o : objects) {
                Apartment apartment = (Apartment) o;
                apartments.add(apartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return apartments;
    }

    @Override
    public Apartment getApartment(int id) {
        Apartment apartment = null;
        sqlCode = "SELECT * FROM apartaments where idapartaments = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            apartment = (Apartment) objectsList().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return apartment;
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete FROM apartaments where idapartaments = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Apartment with id = " + id + "is deleted from DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    @Override
    public void addToDb(Apartment apartment) {
        sqlCode = "insert into apartaments values(null, ?, ?, ?);";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setString(1, apartment.getApartmentType());
            stmt.setString(2, apartment.getCity());
            stmt.setInt(3, apartment.getOwnerId());
            stmt.executeUpdate();
            System.out.println("Apartment" + apartment.getApartmentType() + "is added to DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
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
    }
    return apartment;
    }


    public static void main(String[] args) {
        JDBCApartmentDataAcces jdbcApartmentDataAcces = new JDBCApartmentDataAcces();
        List<Apartment> apartments = jdbcApartmentDataAcces.getApartmentListByIdUser(13);
        for (Apartment apartment : apartments) {
            System.out.println(apartment.toString());
        }

//        Apartment apartment = jdbcApartmentDataAcces.getApartment(4);
//        System.out.println(apartment);
//
//        jdbcApartmentDataAcces.addToDb(apartment);

    }
}
