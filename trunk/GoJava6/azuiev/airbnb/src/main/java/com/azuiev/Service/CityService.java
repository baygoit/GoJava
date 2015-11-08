package com.azuiev.service;

import com.azuiev.dao.CityDao;
import com.azuiev.model.City;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public class CityService {
    private static CityDao dao = new CityDao();

    public List<City> getAll(){
        List<City> list = new ArrayList<City>();
        try {
            list = dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public City getById(Long i){
        City city = null;
        try {
            city = (City)dao.getById(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }


}
