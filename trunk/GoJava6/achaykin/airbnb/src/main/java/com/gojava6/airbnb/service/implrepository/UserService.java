package com.gojava6.airbnb.service.implrepository;

import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.service.IUserService;
import com.gojava6.airbnb.model.user.User;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public class UserService implements IUserService {
    @Override
    public void create(User user) {

    }

    @Override
    public User retrieveById(int userID) {
        return null;
    }

    @Override
    public User retrieveByEMail(String eMail) {
        return null;
    }

    @Override
    public List<User> retrieveAllHostsByCity(CityType city) {
        return null;
    }

    @Override
    public List<User> retrieveAllRentersByCity(CityType city) {
        return null;
    }

    @Override
    public List<User> retrieveAllUsersByCity(CityType city) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void becomeHost(User user) {

    }
}
