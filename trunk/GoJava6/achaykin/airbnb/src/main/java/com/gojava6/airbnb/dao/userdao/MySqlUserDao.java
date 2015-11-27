package com.gojava6.airbnb.dao.userdao;

import com.gojava6.airbnb.Exception.daoexception.MySqlUserDaoException;
import com.gojava6.airbnb.Exception.typeException.CityTypeException;
import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.CityType;
import com.gojava6.airbnb.dao.apartmentdao.MySqlApartmentDao;
import com.gojava6.airbnb.dao.daofactory.MySqlDAOFactory;
import com.gojava6.airbnb.user.Host;
import com.gojava6.airbnb.user.Renter;
import com.gojava6.airbnb.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDAO {

    @Override
    public void create(User user) throws MySqlUserDaoException {
        if (user instanceof Renter) {
            createRenter(user);
        } else {
            createHost(user);
        }
    }

    @Override
    public User retrieveById(int userID) throws MySqlUserDaoException {
        String query = "SELECT * FROM airbnb.user WHERE userID = ?;";

        try (Connection connection = getConnection()) {

            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, userID);

            ResultSet rs = stm.executeQuery();
            rs.next();

            String name = rs.getString("first_name");
            String surname = rs.getString("last_name");
            String eMail = rs.getString("eMail");
            CityType city = CityType.fromValue(rs.getString("city"));
            boolean isHost = rs.getBoolean("is_host");

            if (isHost) {
                List<Apartment> apartments = new MySqlApartmentDao().retrieveAllByHost(userID);
                return new Host(userID, name, surname, eMail, city, apartments);
            } else {
                return new Renter(userID, name, surname, eMail, city);
            }
        } catch (SQLException | CityTypeException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t retrieve user by id.", e);
        }
    }

    @Override
    public User retrieveByEMail(String eMail) throws MySqlUserDaoException {
        String query = "SELECT * FROM airbnb.user WHERE eMail = ?;";
        PreparedStatement pstm;
        ResultSet rs;

        try (Connection connection = getConnection()) {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, eMail);
            rs = pstm.executeQuery();
            rs.next();

            int userID = rs.getInt("userID");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            CityType city = CityType.valueOf(rs.getString("city"));
            boolean isHost = Boolean.valueOf(rs.getString("is_host"));

            if (isHost) {
                List<Apartment> apartments = new MySqlApartmentDao().retrieveAllByHost(userID);
                return new Host(userID, firstName, lastName, eMail, city, apartments);
            } else {
                return new Renter(userID, firstName, lastName, eMail, city);
            }
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t retrieve user by e-Mail.", e);
        }
    }

    @Override
    public List<Host> retrieveAllHostsByCity(CityType city) throws MySqlUserDaoException {
        List<Host> resultList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM airbnb.user WHERE city = ? AND is_host = 1;";

            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, String.valueOf(city));

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                String eMail = rs.getString("eMail");

                List<Apartment> apartments = new MySqlApartmentDao().retrieveAllByHost(userID);
                resultList.add(new Host(userID, name, surname, eMail, city, apartments));
            }
            return resultList;
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t retrieve hosts by city.", e);
        }
    }

    @Override
    public List<Renter> retrieveAllRentersByCity(CityType city) throws MySqlUserDaoException {
        List<Renter> resultList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM airbnb.user WHERE city = ? AND is_host = 0;";

            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, String.valueOf(city));

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                String eMail = rs.getString("eMail");

                resultList.add(new Renter(userID, name, surname, eMail, city));
            }
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t retrieve renters by city.", e);
        }
        return resultList;
    }

    @Override
    public List<User> retrieveAllByCity(CityType city) throws MySqlUserDaoException {
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
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String eMail = rs.getString("eMail");
                Boolean isHost = rs.getBoolean("is_host");

                if (isHost) {
                    List<Apartment> apartments = new MySqlApartmentDao().retrieveAllByHost(userID);
                    resultList.add(new Host(userID, firstName, lastName, eMail, city, apartments));
                } else {
                    resultList.add(new Renter(userID, firstName, lastName, eMail, city));
                }
            }
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t retrieve users by city.", e);
        }
        return resultList;
    }

    @Override
    public void update(User user) throws MySqlUserDaoException {
        String query = "UPDATE airbnb.user " +
                "SET first_name = ?, last_name = ?, eMail = ?, city = ? WHERE userID = ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, user.getFirstName());
            pstm.setString(2, user.getLastName());
            pstm.setString(3, user.getEMail());
            pstm.setString(4, user.getEMail());
            pstm.setInt(5, user.getUserId());
            pstm.executeUpdate();

            if (user instanceof Host) {
                List<Apartment> apartments = user.getApartments();
                for (Apartment apartment : apartments) {
                    new MySqlApartmentDao().update(apartment);
                }
            }
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t update user.", e);
        }
    }

    @Override
    public void delete(User user) throws MySqlUserDaoException {
        String query = "DELETE FROM airbnb.user WHERE userID = ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, user.getUserId());
            pstm.executeUpdate();
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t delete user.", e);
        }
    }

    @Override
    public void becomeHost(User renter) throws MySqlUserDaoException {
        String query = "UPDATE airbnb.user SET is_host = ? WHERE userID = ?;"; //todo true hardcode

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setBoolean(1, true);
            pstm.setInt(2, renter.getUserId());
            pstm.executeUpdate();
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t create a host account for renter.", e);
        }
    }

    private void createHost(User host) throws MySqlUserDaoException {
        String query = "INSERT INTO airbnb.user (first_name, last_name, eMail, city, is_host)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);

            pstm.setString(1, host.getFirstName());
            pstm.setString(2, host.getLastName());
            pstm.setString(3, host.getEMail());
            pstm.setString(4, String.valueOf(host.getCity()));
            pstm.setBoolean(5, false);
            pstm.executeUpdate();

            List<Apartment> apartments = host.getApartments();
            for (Apartment apartment : apartments) {
                new MySqlApartmentDao().create(apartment); //todo join on?
            }
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t create host in MySQL database.", e);
        }
    }

    private void createRenter(User renter) throws MySqlUserDaoException {
        String query = "INSERT INTO airbnb.user (first_name, last_name, eMail, city)" +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);

            pstm.setString(1, renter.getFirstName());
            pstm.setString(2, renter.getLastName());
            pstm.setString(3, renter.getEMail());
            pstm.setString(4, String.valueOf(renter.getCity()));
            pstm.executeUpdate();
        } catch (SQLException | MySqlUserDaoException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("Can`t create renter in MySQL database.", e);
        }
    }

    private Connection getConnection() throws MySqlUserDaoException {
        try {
            return new MySqlDAOFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MySqlUserDaoException("No connection", e);
        }
    }
}
