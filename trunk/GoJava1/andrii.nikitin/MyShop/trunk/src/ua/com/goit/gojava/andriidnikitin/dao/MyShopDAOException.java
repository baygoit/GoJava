package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.SQLException;

public class MyShopDAOException extends SQLException {

	/**
	 * This exception appears when something goes wrong in DAO layer
	 */
	private static final long serialVersionUID = 3721318380589654405L;

	public MyShopDAOException(SQLException e) {
		super(e);
	}
	

}
