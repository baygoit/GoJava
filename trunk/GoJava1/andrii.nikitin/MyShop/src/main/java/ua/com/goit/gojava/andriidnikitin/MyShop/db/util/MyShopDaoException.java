package ua.com.goit.gojava.andriidnikitin.MyShop.db.util;

import java.sql.SQLException;

public class MyShopDaoException extends SQLException {

	/**
	 * This exception is being thrown when something goes wrong in DAO layer
	 */
	private static final long serialVersionUID = 3721318380589654405L;

	public MyShopDaoException(SQLException e) {
		super(e);
	}

	public MyShopDaoException(String string) {
		super(string);
	}

	public MyShopDaoException(Exception e) {
		super(e);
	}
	

}
