package com.gojava6.airbnb.service.daoservice;

import com.gojava6.airbnb.Exception.daoexception.MySqlApartmentDaoException;
import com.gojava6.airbnb.model.apartment.*;
import com.gojava6.airbnb.dao.apartmentdao.MySqlApartmentDao;
import com.gojava6.airbnb.service.IApartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 24.11.2015
 */
public class ApartmentService implements IApartmentService {
    private final static Logger LOGGER = LogManager.getLogger(ApartmentService.class);

    private MySqlApartmentDao apartmentDao = new MySqlApartmentDao();
    private boolean operationResult;
    private List<Apartment> resultList;

    public void create(Apartment apartment) {
        try {
            if (apartment != null) {
                operationResult = apartmentDao.create(apartment);
            }
            if (operationResult) {
                LOGGER.debug("Create apartment completed.");
            } else {
                LOGGER.error("Cannot create apartment! " + apartment.getCity().toString() + " " + apartment.getApartmentType().toString());
            }
        } catch (MySqlApartmentDaoException e) {
            e.printStackTrace();
        }
    }

    public Apartment retrieveByID(int id) {
        Apartment apartment = null;
        try {
            if (id != 0) {
                apartment = apartmentDao.retrieveByID(id);
            }
            if (apartment != null) {
                LOGGER.info("Retrieve apartment " + apartment.getApartmentID() + " successful completed.");
            } else {
                LOGGER.error("Cannot retrieve apartment by id: " + id + "!");
            }
        } catch (MySqlApartmentDaoException e) {
            e.printStackTrace();
        }
        return apartment;
    }

    public List<Apartment> retrieveAllByCity(CityType city) {
        try {
            if (city != null) {
                resultList = apartmentDao.retrieveAllByCity(city);
            }
            if (resultList != null) {
                LOGGER.debug("Retrieve all apartments by city successful completed.");
            } else {
                LOGGER.error("Cannot retrieve all apartments by city: " + city + "!");
            }
        } catch (MySqlApartmentDaoException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Apartment> retrieveAllByHost(int hostID) {

        try {
            if (hostID != 0) {
                resultList = apartmentDao.retrieveAllByHost(hostID);  //todo check if we havent apartments for this host
            }
            if (resultList != null) {
                LOGGER.debug("Retrieve all apartments by hostID successful completed!");
            } else {
                LOGGER.error("Cannot retrieve all apartments by hostID: " + hostID);
            }
        } catch (MySqlApartmentDaoException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void update(Apartment apartment) { //todo check null and if id exist in db
        try {
            if (apartment != null) {
                operationResult = apartmentDao.update(apartment);
            }
            if (operationResult) {
                LOGGER.info("Update apartment successful complete! ApartmentID: " + apartment.getApartmentID());
            } else {
                LOGGER.error("Cannot update apartment: " + apartment.getApartmentID());
            }
        } catch (MySqlApartmentDaoException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void delete(int apartmentID) { //todo check 0
        try {
            if (apartmentID != 0) {
                operationResult = apartmentDao.delete(apartmentID);
            }
            if (operationResult) {
                LOGGER.debug("Apartment(id:" + apartmentID + ") successful deleted.");
            } else {
                LOGGER.error("Cannot delete apartment: " + apartmentID);
            }
        } catch (MySqlApartmentDaoException e) {
            e.printStackTrace();
        }
    }
}
