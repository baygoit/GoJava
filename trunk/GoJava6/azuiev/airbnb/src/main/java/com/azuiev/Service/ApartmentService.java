package com.azuiev.service;

import com.azuiev.dao.ApartmentDao;
import com.azuiev.dao.CityDao;
import com.azuiev.model.Apartment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 02.11.15.
 */
public class ApartmentService  {
    private static ApartmentDao dao = new ApartmentDao();

    public List<Apartment> getAll(){
        List<Apartment> list = new ArrayList<Apartment>();
        try {
            list = (List<Apartment>) dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Apartment getById(Long i){
        Apartment Apartment = null;
        try {
            Apartment = dao.getById(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Apartment;
    }

    public static List<Apartment> getByCity(Long id) {

        List<Apartment> list = new ArrayList<Apartment>();
        try {
          list = (List<Apartment>) dao.getByCity(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
