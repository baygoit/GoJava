package com.vopanasyuk.service;

import com.vopanasyuk.dao.DaoCity;
import com.vopanasyuk.model.City;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hunky on 31.10.2015.
 */
public class CityService {
    private static DaoCity dao = new DaoCity();

    public List<City> getAll(){
        List<City> list = new ArrayList<City>();
        try {
            list = (List<City>) dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public City getById(Integer i){
        City city = null;
        try {
            city = dao.getById(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }


}