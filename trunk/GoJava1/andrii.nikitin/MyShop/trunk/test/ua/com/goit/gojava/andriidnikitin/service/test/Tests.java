package ua.com.goit.gojava.andriidnikitin.service.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import ua.com.goit.gojava.andriidnikitin.dao.DaoFactory;
import ua.com.goit.gojava.andriidnikitin.dao.GenericDao;
import ua.com.goit.gojava.andriidnikitin.dao.PostgresqlDaoFactory;
import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.domain.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.domain.service.GoodCatalogImpl;
import ua.com.goit.gojava.andriidnikitin.domain.service.util.MyShopException;


public class Tests {
	
	//TODO -create *before* part where switch to test DB
	
	@Test
	public void DAOSmokeTest(){
		DaoFactory factory = PostgresqlDaoFactory.getInstance() ;
		assertNotNull(factory);
		Connection connection = null;
		try {
			connection = factory.getConnection();
		} catch (MyShopDaoException e) {
			//fail(); unable to set
		}
		GenericDao<Good> goodDAO = factory.getGoodDao(connection);
		assertNotNull(goodDAO);
		GenericDao<GoodType> typeDAO = factory.getGoodTypeDao(connection);
		assertNotNull(typeDAO);
	}
	
	@Test
	public void ServiceSmokeTest(){
		GoodCatalog catalog = GoodCatalogImpl.getInstance();
		assertNotNull(catalog);
		try {
			assertNotNull(catalog.getAllGoods());
		} catch (MyShopException e) {
			//fail(); unable to set
		}		
		try {
			assertNotNull(catalog.getAllTypes());
		} catch (MyShopException e) {
			//fail(); unable to set
		}		
	}
}
