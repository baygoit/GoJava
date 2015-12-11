package com.gojava6.airbnb.dao.userdao;

import com.gojava6.airbnb.Exception.daoexception.MySqlUserDaoException;
import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.model.user.User;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 28.10.2015
 */
public interface UserDAO{

    boolean create(User user) throws MySqlUserDaoException;
    User retrieveById(int userID) throws MySqlUserDaoException;
    User retrieveByEMail(String eMail) throws MySqlUserDaoException;
    List<User> retrieveAllHostsByCity(CityType city) throws MySqlUserDaoException;
    List<User> retrieveAllRentersByCity(CityType city) throws MySqlUserDaoException;
    List<User> retrieveAllUsersByCity(CityType city) throws MySqlUserDaoException;
    boolean update(User user) throws MySqlUserDaoException;
    boolean delete(User user) throws MySqlUserDaoException;
    boolean becomeHost(User renter) throws MySqlUserDaoException;

}
