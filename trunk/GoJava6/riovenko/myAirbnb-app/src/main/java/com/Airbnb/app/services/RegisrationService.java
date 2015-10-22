package com.Airbnb.app.services;

import com.Airbnb.app.DAO.UserDAO;
import com.Airbnb.app.DAO.UserDAOimpl;
import com.Airbnb.app.model.User;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by romanroma on 18.10.15.
 */
public class RegisrationService {

    private UserDAO userDAO = new UserDAOimpl();

    public void register (String name, String surname, String email, Boolean isHost){
        try {
            if (userDAO.checkExistingUser(email) == 1){
                System.out.println ("User : " + email + " is already exist");
                return;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        User user = new User (name, surname, email, isHost);
        register(user);
    }

    public void register (User user){
        if (!user.validation()){
            System.out.println ("User : " + user.getId() + "Fail validation");
            return;
        }
        try {
            userDAO.addUser(user);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUser (int id){
        try{
            userDAO.deleteUser(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers (){
        List<User> usersList = new LinkedList<>();
        try{
            usersList = userDAO.getAllUsers();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usersList;
    }

    public List<User> getAllClients (){
        List<User> clientsList = new LinkedList<>();
        try{
            clientsList = userDAO.getAllClients();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return clientsList;
    }

    public List<User> getAllHosts (){
        List<User> hostsList = new LinkedList<>();
        try{
            hostsList = userDAO.getAllHosts();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return hostsList;
    }

    public User getUserById (int id){
        try {
            return userDAO.getUserById(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
