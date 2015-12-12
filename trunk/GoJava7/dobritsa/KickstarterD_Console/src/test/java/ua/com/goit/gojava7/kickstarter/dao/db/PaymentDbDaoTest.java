package ua.com.goit.gojava7.kickstarter.dao.db;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PaymentDbDaoTest {
	
	
	@Mock
	private BasicDataSource basicDataSource;
	@Mock
	private ResultSet resultSet;
	@Mock
	private PrintStream printSteam;
	@InjectMocks
	PaymentDbDao paymentDao = new PaymentDbDao(basicDataSource);
	
	
	@Test
	public void testValidateCard() {		
		assertTrue(paymentDao.validateCard("1111222233334444"));
		assertFalse(paymentDao.validateCard("1111"));
	}
	
	@Test
	public void testValidateName() {		
		assertTrue(paymentDao.validateName("Nike"));
		assertFalse(paymentDao.validateName("1111"));
	}
	
	@Test
	public void testReadElement() throws SQLException {		
		assertNull(paymentDao.readElement(resultSet));
	}
	
	@Test
	public void testToString() throws SQLException {		
		assertNull(paymentDao.readElement(resultSet));
	}

}
