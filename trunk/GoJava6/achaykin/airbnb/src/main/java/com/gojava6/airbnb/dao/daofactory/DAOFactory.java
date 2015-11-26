package com.gojava6.airbnb.dao.daofactory;



import com.gojava6.airbnb.dao.apartmentdao.MySqlApartmentDao;
import com.gojava6.airbnb.dao.userdao.MySqlUserDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Autor Andrey Chaykin
 * @Since 28.10.2015
 */
public interface DAOFactory {

    Connection getConnection() throws SQLException;
    MySqlUserDao getUserDAO();
    MySqlApartmentDao getApartmentDAO ();

}
