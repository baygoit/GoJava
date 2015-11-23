package com.gojava6.airbnb.dao.userdao;

import com.gojava6.airbnb.Exception.daoexception.MySqlUserDaoException;
import com.gojava6.airbnb.apartment.CityType;
import com.gojava6.airbnb.user.Host;
import com.gojava6.airbnb.user.Renter;
import com.gojava6.airbnb.user.User;

import java.sql.SQLException;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 28.10.2015
 */
public interface UserDAO{

    void create(User user) throws MySqlUserDaoException;
    User retrieveById(int userID) throws MySqlUserDaoException;
    User retrieveByEMail(String eMail) throws MySqlUserDaoException;
    List<Host> retrieveAllHostsByCity(CityType city) throws MySqlUserDaoException;
    List<Renter> retrieveAllRentersByCity(CityType city) throws MySqlUserDaoException;
    List<User> retrieveAllByCity(CityType city) throws MySqlUserDaoException;
    void update(User user) throws MySqlUserDaoException;
    void delete(User user) throws MySqlUserDaoException;
    void becomeHost(User renter) throws MySqlUserDaoException;

}
