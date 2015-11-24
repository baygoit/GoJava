package com.gojava6.airbnb.dao.apartmentdao;

import com.gojava6.airbnb.Exception.daoexception.MySqlApartmentDaoException;
import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.CityType;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 13.11.2015
 */
public interface ApartmentDAO {

    void create(Apartment apartment) throws MySqlApartmentDaoException;
    Apartment retrieveByID(int id) throws MySqlApartmentDaoException;
    List<Apartment> retrieveAllByCity(CityType city) throws MySqlApartmentDaoException;
    List<Apartment> retrieveAllByHost(int hostID) throws MySqlApartmentDaoException;
    void update(Apartment apartment) throws MySqlApartmentDaoException;
    void delete(int apartmentID) throws MySqlApartmentDaoException;
}
