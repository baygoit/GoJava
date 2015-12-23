package com.airbnb.dao;

import com.airbnb.model.Admin;

import java.util.List;

/**
 * Created by Игорь on 19.11.2015.
 */
public interface IAdmin {
    List<Admin> getAllAdmins();
    Admin getAdminById(int id);
    void delete(int id);
    void addToDb(Admin admin);
}
