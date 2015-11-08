package com.vopanasyuk.service;

import com.vopanasyuk.dao.DaoUser;
import com.vopanasyuk.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hunky on 31.10.2015.
 */
public class UserService {
    private static DaoUser dao = new DaoUser();

    public List<User> getAll(){
        List<User> list = new ArrayList<User>();
        try {
            list = dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public User getById(Integer i){
        User user = null;
        try {
            user = dao.getById(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}