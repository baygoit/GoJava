package ua.com.goit.gojava.andriidnikitin.service.util;

import java.sql.SQLException;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;

public class ShopException extends Exception {

	private static final long serialVersionUID = 8788269382188843317L;

	public ShopException(String string) {
		super(string);
	}

	public ShopException() {
		super();
	}

	public ShopException(MyShopDAOException e) {
		super(e);
	}

	public ShopException(SQLException e) {
		super(e);
	}

}
