package ua.com.goit.gojava.POM.persistence.postgresDB;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.Money;

public class CashMovementDAOTest {
	
	/*@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateAndRetrieveAllAndDelete() {

		CashMovementDAO cashMovementDAO = new CashMovementDAO();
		CashMovementEntry cashMovementEntry = null;
		List<CashMovementEntry> allEntries = null;
		
		try {
			allEntries = cashMovementDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all CashMovementEntry: "+e.getMessage());
		}
		
		try {
			cashMovementEntry = cashMovementDAO.create();
		} catch (POMDataModelException e) {
			fail("Fail to create CashMovementEntry: "+e.getMessage());
		}
		
		long size = allEntries.size();
		
		try {
			allEntries = cashMovementDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all CashMovementEntry: "+e.getMessage());
		}
		assertNotNull(cashMovementEntry.getId());
		assertEquals(size+1, allEntries.size());
		
		try {
			
			cashMovementDAO.delete(cashMovementEntry);
			
		} catch (POMDataModelException e) {
			fail("Fail to delete CashMovementEntry: "+e.getMessage());
		}
		
		try {
			allEntries = cashMovementDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all CashMovementEntry: "+e.getMessage());
		}
		
		assertEquals(size, allEntries.size());
		
	}
	
	@Test
	public void testSaveObject() {

		CashMovementDAO cashMovementDAO = new CashMovementDAO();
		CashMovementEntry cashMovementEntry = new CashMovementEntry();
		
		Date time = Calendar.getInstance().getTime();
		Currency currency = Currency.getInstance("UAH");
		
		BankAccount stubBankAccount = new BankAccount() {
			
			@Override
			public long getId() {
				
				return 3;
				
			}
			
		};
		
		double sumValue = 3.45;
		Money sum = null;
		try {
			sum = new Money(sumValue, currency);
		} catch (POMDataModelException e) {
			fail("Fail to create Money: "+e.getMessage());
		}
		
		cashMovementEntry.setDate(time);
		cashMovementEntry.setBankAccount(stubBankAccount);
		cashMovementEntry.setSum(sum);
		
		assertEquals(cashMovementEntry.getId(),0);
		
		try {
			cashMovementEntry = cashMovementDAO.create(cashMovementEntry);
		} catch (POMDataModelException e) {
			fail("Fail to create CashMovementEntry: "+e.getMessage());
		}
		
		assertNotEquals(cashMovementEntry.getId(),0);
		assertEquals(cashMovementEntry.getDate(),time);
		assertEquals(cashMovementEntry.getSum().getCurrency(),currency);
		try {
			assertEquals(cashMovementEntry.getSum(),new Money(sumValue,currency));
		} catch (POMDataModelException e) {
			fail("Fail to create Money: "+e.getMessage());
		}
	}
	
	@Test
	public void testUpdateAndGetByID() {

		CashMovementDAO cashMovementDAO = new CashMovementDAO();
		List<CashMovementEntry> allEntries = null;
		
		try {
			allEntries = cashMovementDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all CashMovementEntry: "+e.getMessage());
		}
		
		CashMovementEntry lastEntry = allEntries.get(allEntries.size()-1);
		
		Date time = Calendar.getInstance().getTime();
		Currency currency = Currency.getInstance("UAH");
		
		BankAccount stubBankAccount = new BankAccount() {
			
			@Override
			public long getId() {
				
				return 3;
				
			}
			
		};
		
		double sumValue = 3.45;
		Money sum = null;
		try {
			sum = new Money(sumValue, currency);
		} catch (POMDataModelException e) {
			fail("Fail to create Money: "+e.getMessage());
		}
		
		lastEntry.setDate(time);
		lastEntry.setBankAccount(stubBankAccount);
		lastEntry.setSum(sum);
		
		long id = lastEntry.getId();
		
		try {
			cashMovementDAO.update(lastEntry);
		} catch (POMDataModelException e) {
			fail("Fail to update CashMovementEntry: "+e.getMessage());
		}
		
		lastEntry = null;
		
		try {
			lastEntry = cashMovementDAO.retrieveById(id);
		} catch (POMDataModelException e) {
			fail("Fail to retrieve by ID CashMovementEntry: "+e.getMessage());
		}
		
		assertEquals(lastEntry.getId(),id);
		assertEquals(lastEntry.getDate(),time);
		assertEquals(lastEntry.getSum().getCurrency(),currency);
		try {
			assertEquals(lastEntry.getSum(),new Money(sumValue,currency));
		} catch (POMDataModelException e) {
			fail("Fail to create Money: "+e.getMessage());
		}
		
		
	}*/
	
}
