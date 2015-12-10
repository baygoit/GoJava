package com.gojava6.airbnb.service;

import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.model.user.User;
import com.gojava6.airbnb.model.user.UserType;

import java.util.List;

public interface IUserService {

    void create(User user);

    User retrieveById(int userID);

    User retrieveByEMail(String eMail);

    List<User> retrieveAllHostsByCity(CityType city);

    List<User> retrieveAllRentersByCity(CityType city);

    List<User> retrieveAllUsersByCity(CityType city);

    void update(User user);

    void delete(User user);

    void becomeHost(User user);
}

