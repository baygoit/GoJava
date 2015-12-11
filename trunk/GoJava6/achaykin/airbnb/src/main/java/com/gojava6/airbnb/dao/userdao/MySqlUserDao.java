package com.gojava6.airbnb.dao.userdao;

import com.gojava6.airbnb.Exception.daoexception.MySqlUserDaoException;
import com.gojava6.airbnb.Exception.typeException.CityTypeException;
import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.dao.apartmentdao.MySqlApartmentDao;
import com.gojava6.airbnb.dao.daofactory.MySqlDAOFactory;
import com.gojava6.airbnb.model.user.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDAO {

    private Logger LOGGER = LogManager.getLogger(MySqlUserDao.class);

    @Override
    public boolean create(User user) throws MySqlUserDaoException {
        LOGGER.debug("Trying to create user in DB");
        String query = "INSERT INTO airbnb.user (first_name, last_name, eMail, city) " +  //todo smth
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);

            pstm.setString(1, user.getFirstName());
            pstm.setString(2, user.getLastName());
            pstm.setString(3, user.getEMail());
            pstm.setString(4, String.valueOf(user.getCity().toString().toUpperCase()));
            pstm.executeUpdate();
            LOGGER.debug("User is created");//todo check if created
            return true;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            LOGGER.error("Cannot create user in DB", e);
            return false;
//            throw new MySqlUserDaoException("Can`t create user in MySQL database.", e);
        }
    }

    @Override
    public User retrieveById(int userID) throws MySqlUserDaoException {
        LOGGER.debug("Trying to retrieve user by id in DB");
        String query = "SELECT * FROM airbnb.user WHERE userID = ?;";
        PreparedStatement pstm;
        ResultSet rs;
        User result;

        try (Connection connection = getConnection()) {

            pstm = connection.prepareStatement(query);
            pstm.setInt(1, userID);

            rs = pstm.executeQuery();

            if (!rs.next()) {
                return null;
            } else {
                UserType userType = UserType.valueOf(rs.getString("user_type"));
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                String eMail = rs.getString("eMail");
                CityType city = CityType.fromValue(rs.getString("city"));

                result = new User(userID, userType, name, surname, eMail, city);

                if (UserType.HOST.equals(userType)) {
                    result.setApartments(new MySqlApartmentDao().retrieveAllByHost(userID));
                }
                LOGGER.debug("User successful retrieved by id.");

                return result;
            }
        } catch (SQLException | CityTypeException e) {
            e.printStackTrace();
            LOGGER.error("Cannot retrieve user by id from DB", e);
            throw new MySqlUserDaoException("Can`t retrieve user by id.", e);
        }
    }

    @Override
    public User retrieveByEMail(String eMail) throws MySqlUserDaoException {
        String query = "SELECT * FROM airbnb.user WHERE eMail = ?;";
        PreparedStatement pstm;
        ResultSet rs;
        User result;

        try (Connection connection = getConnection()) {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, eMail);
            rs = pstm.executeQuery();

            if (!rs.next()) {
                return null;
            } else {
                int userID = rs.getInt("userID");
                UserType userType = UserType.valueOf(rs.getString("user_type"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                CityType city = CityType.valueOf(rs.getString("city"));

                result = new User(userID, userType, firstName, lastName, eMail, city);

                if (UserType.HOST.equals(userType)) {
                    result.setApartments(new MySqlApartmentDao().retrieveAllByHost(userID));
                }
                LOGGER.debug("Renter successful retrieved by eMail from DB.");
                return result;
            }
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            LOGGER.error("Cannot retrieve user by eMail in DB", e);
            throw new MySqlUserDaoException("Can`t retrieve user by e-Mail.", e);
        }
    }

    @Override
    public List<User> retrieveAllHostsByCity(CityType city) throws MySqlUserDaoException {
        List<User> resultList = new ArrayList<>();
        PreparedStatement pstm;
        ResultSet rs;

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM airbnb.user WHERE city = ? AND user_type = 'HOST'";

            pstm = connection.prepareStatement(query);
            pstm.setString(1, String.valueOf(city));

            rs = pstm.executeQuery();
            if (rs.next()) {
                do {
                    int userID = rs.getInt("userID");
                    UserType userType = UserType.valueOf(rs.getString("user_type"));
                    String name = rs.getString("first_name");
                    String surname = rs.getString("last_name");
                    String eMail = rs.getString("eMail");

                    List<Apartment> apartments = new MySqlApartmentDao().retrieveAllByHost(userID);
                    resultList.add(new User(userID, userType, name, surname, eMail, city, apartments));
                } while (rs.next());
            }
            LOGGER.debug("All hosts successful retrieved by city from DB.");
            return resultList;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            LOGGER.debug("Cannot retrieve all hosts from DB by city. " + e);
            throw new MySqlUserDaoException("Can`t retrieve hosts by city.", e);
        }
    }

    @Override
    public List<User> retrieveAllRentersByCity(CityType city) throws MySqlUserDaoException {
        String query = "SELECT * FROM airbnb.user WHERE city = ? AND user_type = 'RENTER';";
        List<User> resultList = null;
        PreparedStatement pstm;
        ResultSet rs;
        try (Connection connection = getConnection()) {

            pstm = connection.prepareStatement(query);
            pstm.setString(1, String.valueOf(city));

            rs = pstm.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                UserType userType = UserType.valueOf(rs.getString("user_type"));
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                String eMail = rs.getString("eMail");

                User user = new User(userID, userType, name, surname, eMail);
                user.setCity(city);

                resultList.add(user);
                LOGGER.debug("All renters successful retrieved by city from DB.");
            }
            return resultList;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            LOGGER.debug("Cannot retrieve all renters from DB by city. " + e);
            throw new MySqlUserDaoException("Can`t retrieve renters by city.", e);
        }
    }

    @Override
    public List<User> retrieveAllUsersByCity(CityType city) throws MySqlUserDaoException {
        String query = "SELECT * FROM airbnb.user WHERE city = ?;";
        PreparedStatement pstm;
        ResultSet rs;
        List<User> resultList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, String.valueOf(city));
            rs = pstm.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("userID");
                UserType userType = UserType.valueOf(rs.getString("user_type"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String eMail = rs.getString("eMail");

                if (UserType.HOST.equals(userType)) {
                    List<Apartment> apartments = new MySqlApartmentDao().retrieveAllByHost(userID);  //todo change user
                    resultList.add(new User(userID, userType, firstName, lastName, eMail, city, apartments));
                } else {
                    User user = new User(userID, userType, firstName, lastName, eMail);
                    user.setCity(city);
                    resultList.add(user);
                }
            }
            LOGGER.debug("All users successful retrieved by city from DB.");
            return resultList;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t retrieve all users by city.", e);
        }
    }

    @Override
    public boolean update(User user) throws MySqlUserDaoException {
        String query = "UPDATE airbnb.user " +
                "SET user_type = ?, first_name = ?, last_name = ?, eMail = ?, city = ? WHERE userID = ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, user.getUserType().toString());
            pstm.setString(2, user.getFirstName());
            pstm.setString(3, user.getLastName());
            pstm.setString(4, user.getEMail());
            pstm.setString(5, user.getCity().toString());
            pstm.setInt(6, user.getUserId());
            pstm.executeUpdate();

            if (UserType.HOST.equals(user.getUserType())) {
                for (Apartment apartment : user.getApartments()) {
                    new MySqlApartmentDao().update(apartment);
                }
            }
            LOGGER.debug("User successful updated in DB.");
            return true;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t update user.", e);
        }
    }

    @Override
    public boolean delete(User user) throws MySqlUserDaoException {
        String query = "DELETE FROM airbnb.user WHERE userID = ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, user.getUserId());
            pstm.executeUpdate();
            LOGGER.debug("User successful deleted from DB.");
            return true;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            LOGGER.error("Cannot delete user from DB", e);
            throw new MySqlUserDaoException("Can`t delete user from DB.", e);
        }
    }

    @Override
    public boolean becomeHost(User renter) throws MySqlUserDaoException {
        String query = "UPDATE airbnb.user SET user_type = 'HOST' WHERE userID = ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, renter.getUserId());
            pstm.executeUpdate();
            LOGGER.debug("User has been defined in DB as host.");
            return true;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            LOGGER.error("Cannot define user as host", e);
            throw new MySqlUserDaoException("Can`t create a host account for renter.", e);
        }
    }

    private Connection getConnection() throws MySqlUserDaoException {
        try {
            LOGGER.debug("Trying to get connection to DB");
            return new MySqlDAOFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("No connection with database", e);
            throw new MySqlUserDaoException("No connection", e);
        }
    }
}
