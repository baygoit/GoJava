package com.azuiev.service;

import com.azuiev.dao.DaoUser;
import com.azuiev.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
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

    public User login(String email, String password) {
        User user = null;
        try {
            user = dao.login(email,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
