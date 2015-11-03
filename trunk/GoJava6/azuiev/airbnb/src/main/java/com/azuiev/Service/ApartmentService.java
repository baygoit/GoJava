package com.azuiev.service;

import com.azuiev.dao.DaoApartment;
import com.azuiev.model.Apartment;
import com.azuiev.model.City;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 02.11.15.
 */
public class ApartmentService  {
    private static DaoApartment dao = new DaoApartment();

    public List<Apartment> getAll(){
        List<Apartment> list = new ArrayList<Apartment>();
        try {
            list = (List<Apartment>) dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Apartment getById(Integer i){
        Apartment Apartment = null;
        try {
            Apartment = dao.getById(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Apartment;
    }

    public static List<Apartment> getByCity(Integer id) {

        List<Apartment> list = new ArrayList<Apartment>();
        try {
            list = (List<Apartment>) dao.getByCity(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
