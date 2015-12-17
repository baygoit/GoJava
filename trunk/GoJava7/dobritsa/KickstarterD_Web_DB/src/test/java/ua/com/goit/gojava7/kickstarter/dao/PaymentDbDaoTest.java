package ua.com.goit.gojava7.kickstarter.dao;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDbDao;

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
	public void testReadElement() throws SQLException {		
		assertNull(paymentDao.readElement(resultSet));
	}
	
	@Test
	public void testToString() throws SQLException {		
		assertNull(paymentDao.readElement(resultSet));
	}

}
