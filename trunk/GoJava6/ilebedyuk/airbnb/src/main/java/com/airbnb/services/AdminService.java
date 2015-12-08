package com.airbnb.services;

import com.airbnb.dao.IAdmin;
import com.airbnb.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Игорь on 19.11.2015.
 */
@Component
public class AdminService {
    @Autowired
    private IAdmin iAdmin;

    public AdminService() {}

    public AdminService(IAdmin iAdmin) {
        this.iAdmin = iAdmin;
    }

    public List<Admin> getAllAdmins(){
        List<Admin> admins = iAdmin.getAllAdmins();
        return admins;
    }

    public Admin getAdminById(int id){
        Admin admin = iAdmin.getAdminById(id);
        return admin;
    }

    public void delete(int id){
        iAdmin.delete(id);
    }

    public void registerAdmin(Admin admin){
        iAdmin.addToDb(admin);
    }

    public boolean isAdmin(String email, String password) {
        List<Admin> admins = getAllAdmins();
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void printAllAdmin(){
        List<Admin> admins = getAllAdmins();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }
}
