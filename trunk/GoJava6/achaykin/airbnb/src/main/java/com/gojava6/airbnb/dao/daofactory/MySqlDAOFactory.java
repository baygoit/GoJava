package com.gojava6.airbnb.dao.daofactory;

import com.gojava6.airbnb.dao.reservedapartment.MySqlReservedApartmentDAO;
import com.gojava6.airbnb.dao.apartmentdao.MySqlApartmentDao;
import com.gojava6.airbnb.dao.userdao.MySqlUserDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDAOFactory implements DAOFactory {

    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/airbnb";
    private static final String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public MySqlUserDao getUserDAO() {
        return new MySqlUserDao();
    }

    public MySqlApartmentDao getApartmentDAO() {
        return new MySqlApartmentDao();
    }

    public MySqlReservedApartmentDAO getReserveBookDAO() { return new MySqlReservedApartmentDAO(); }

    public MySqlDAOFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
