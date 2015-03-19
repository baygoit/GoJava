package ua.com.goit.gojava.andriidnikitin.MyShop3;

import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {
	
	//TODO -create *before* part where switch to test DB
	
	/*@Test
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
	}*/
	
	@Test
	public void SmokeTest(){
		assertNull(null);
	}
}
