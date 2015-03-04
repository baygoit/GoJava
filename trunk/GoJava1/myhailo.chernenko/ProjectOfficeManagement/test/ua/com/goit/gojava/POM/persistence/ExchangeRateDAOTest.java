package ua.com.goit.gojava.POM.persistence;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;

public class ExchangeRateDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateAndRetrieveAll() {

		ExchangeRateDAO exchangeRateDAO = new ExchangeRateDAO();
		ExchangeRate exchangeRate = null;
		List<ExchangeRate> allRates = null;
		
		try {
			allRates = exchangeRateDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all ExchangeRates: "+e.getMessage());
		}
		
		try {
			exchangeRate = exchangeRateDAO.create();
		} catch (POMDataModelException e) {
			fail("Fail to create ExchangeRate: "+e.getMessage());
		}
		
		//long lastId = 0;
		if(allRates.size() != 0 ){
			allRates.get(allRates.size()-1).getId();
		}
		
		assertNotNull(exchangeRate.getId());
		
	}
	
	@Test
	public void testSaveObject() {

		ExchangeRateDAO exchangeRateDAO = new ExchangeRateDAO();
		ExchangeRate exchangeRate = new ExchangeRate();
		
		Date time = Calendar.getInstance().getTime();
		Currency currency = Currency.getInstance("UAH");
		
		exchangeRate.setDate(time);
		exchangeRate.setFromCurrency(currency);
		exchangeRate.setToCurrency(currency);
		exchangeRate.setMultiplicity(100);
		exchangeRate.setRate(100);
		
		assertEquals(exchangeRate.getId(),0);
		
		try {
			exchangeRateDAO.create(exchangeRate);
		} catch (POMDataModelException e) {
			fail("Fail to create ExchangeRate: "+e.getMessage());
		}
		
		assertNotEquals(exchangeRate.getId(),0);
		
	}
	
	@Test
	public void testUpdateAndGetByID() {

		ExchangeRateDAO exchangeRateDAO = new ExchangeRateDAO();
		List<ExchangeRate> allRates = null;
		
		try {
			allRates = exchangeRateDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all ExchangeRates: "+e.getMessage());
		}
		
		ExchangeRate lastRate = allRates.get(allRates.size()-1);
		
		Date time = Calendar.getInstance().getTime();
		Currency currency = Currency.getInstance("UAH");
		
		lastRate.setDate(time);
		lastRate.setFromCurrency(currency);
		lastRate.setToCurrency(currency);
		lastRate.setMultiplicity(100);
		lastRate.setRate(100);
		
		long id = lastRate.getId();
		
		try {
			exchangeRateDAO.update(lastRate);
		} catch (POMDataModelException e) {
			fail("Fail to update ExchangeRate: "+e.getMessage());
		}
		
		lastRate = null;
		
		try {
			lastRate = exchangeRateDAO.retrieveById(id);
		} catch (POMDataModelException e) {
			fail("Fail to retrieve by ID ExchangeRate: "+e.getMessage());
		}
		
		assertEquals(lastRate.getId(),id);
		assertEquals(lastRate.getDate(), time);
		assertEquals(lastRate.getFromCurrency(),currency);
		assertEquals(lastRate.getToCurrency(),currency);
		assertEquals(lastRate.getMultiplicity(),100);
		assertEquals(lastRate.getRate(),100);
		
	}
	
	//@Test
	public void testDelete() {

		ExchangeRateDAO exchangeRateDAO = new ExchangeRateDAO();
		List<ExchangeRate> allRates = null;
		
		try {
			allRates = exchangeRateDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all ExchangeRates: "+e.getMessage());
		}
		
		try {
			
			for(int i = allRates.size()-1; i >= 0; i-- ) {
		
				ExchangeRate exchangeRate = allRates.get(i);
				exchangeRateDAO.delete(exchangeRate);
			}
			
		} catch (POMDataModelException e) {
			fail("Fail to delete ExchangeRate: "+e.getMessage());
		}
		
		try {
			allRates = exchangeRateDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all ExchangeRates: "+e.getMessage());
		}
		
		assertEquals(allRates.size(),0);
		
	}

}
