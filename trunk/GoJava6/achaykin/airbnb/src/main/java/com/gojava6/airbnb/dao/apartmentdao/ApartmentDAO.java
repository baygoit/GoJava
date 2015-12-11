package com.gojava6.airbnb.dao.apartmentdao;

import com.gojava6.airbnb.Exception.daoexception.MySqlApartmentDaoException;
import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.model.apartment.CityType;


import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 13.11.2015
 */
public interface ApartmentDAO {

    boolean create(Apartment apartment) throws MySqlApartmentDaoException;
    Apartment retrieveByID(int id) throws MySqlApartmentDaoException;
    List<Apartment> retrieveAllByCity(CityType city) throws MySqlApartmentDaoException;
    List<Apartment> retrieveAllByHost(int hostID) throws MySqlApartmentDaoException;
    boolean update(Apartment apartment) throws MySqlApartmentDaoException;
    boolean delete(int apartmentID) throws MySqlApartmentDaoException;
}
