package com.gojava6.airbnb.service.daoservice;

import com.gojava6.airbnb.Exception.UserValidationException;
import com.gojava6.airbnb.Exception.daoexception.MySqlUserDaoException;
import com.gojava6.airbnb.dao.daofactory.MySqlDAOFactory;
import com.gojava6.airbnb.dao.userdao.MySqlUserDao;
import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.model.user.User;
import com.gojava6.airbnb.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

import static com.gojava6.airbnb.validation.UserValidation.validationEMail;

/**
 * @Autor Andrey Chaykin
 * @Since 25.11.2015
 */
public class UserService implements IUserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private MySqlUserDao userDao = new MySqlDAOFactory().getUserDAO();
    private User user;
    private boolean operResult;
    private List<User> resultList;

    public void create(User user) { //todo not like object in arg
        try {
            if (user != null) {
                operResult = userDao.create(user);
            }
            if (operResult) {
                LOGGER.debug("Create user successful completed.");
            } else {
                LOGGER.error("Cannot create user: " + user.getUserId() + "in DB.");
            }
        } catch (MySqlUserDaoException e) {
            e.printStackTrace();
        }
    }

    public User retrieveById(int userID) {
        LOGGER.debug("Trying retrieve user by id");
        try {
            if (userID != 0) {
                user = userDao.retrieveById(userID);
            }
            if (user != null) {
                LOGGER.debug("Retrieve user by id successful complete.");
            } else {
                LOGGER.debug("Cannot find user by id: " + userID + " in DB.");
            }
        } catch (MySqlUserDaoException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User retrieveByEMail(String eMail) {
        try {
            if (validationEMail(eMail)) {
                user = userDao.retrieveByEMail(eMail);
            }
            if (user != null) {
                LOGGER.debug("Retrieve user by e-mail successful complete. UserID: " + user.getUserId());
            } else {
                LOGGER.debug("Cannot find user by e-mail: " + eMail + " in DB.");
            }
        } catch (MySqlUserDaoException | UserValidationException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> retrieveAllHostsByCity(CityType city) {
        try {
            if (city != null) {
                resultList = userDao.retrieveAllHostsByCity(city);
            }
            if (resultList != null && !resultList.isEmpty()) {
                LOGGER.debug("Retrieve list of hosts by city successful complete.");
            } else {
                LOGGER.error("Cannot find any host by city: " + city);
            }
        } catch (MySqlUserDaoException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<User> retrieveAllRentersByCity(CityType city) {
        try {
            if (city != null) {
                resultList = userDao.retrieveAllRentersByCity(city);
            }
            if (resultList != null && !resultList.isEmpty()) {
                LOGGER.debug("Retrieve list of renters by city successful complete.");
            } else {
                LOGGER.error("Cannot find any renter by city: " + city);
            }
        } catch (MySqlUserDaoException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<User> retrieveAllUsersByCity(CityType city) {
        try {
            if (city != null) {
                resultList = userDao.retrieveAllUsersByCity(city);
            }
            if (resultList != null && !resultList.isEmpty()) {
                LOGGER.debug("Retrieve list of users by city successful complete.");
            } else {
                LOGGER.debug("Cannot find any host or renter by city: " + city);
            }
        } catch (MySqlUserDaoException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void update(User user) {
        try {
            if (user != null) {
                operResult = userDao.update(user);
            }
            if (operResult) {
                LOGGER.debug("Update user successful complete.");
            } else {
                LOGGER.error("Cannot update user. UserID: " + user.getUserId());
            }
        } catch (MySqlUserDaoException e) {
            e.printStackTrace();
        }
    }

    public void delete(User user) {
        try {
            if (user != null) {
                operResult = userDao.delete(user);
            }
            if (operResult) {
                LOGGER.debug("User successful deleted.");
            } else {
                LOGGER.error("Cannot delete user. UserID: " + user.getUserId());
            }
        } catch (MySqlUserDaoException e) {
            e.printStackTrace();
        }
    }

    public void becomeHost(User renter) {
        try {
            if (renter != null) {
                operResult = userDao.becomeHost(renter);
            }
            if (operResult) {
                LOGGER.debug("Operation become host successful completed.");
            }
        } catch (MySqlUserDaoException e) {
            LOGGER.error("Operation becomeHost is failed! Renter: " + renter.getUserId());
            e.printStackTrace();
        }
    }
}
