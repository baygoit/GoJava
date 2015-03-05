package ua.com.goit.gojava.POM.persistence.postgresDB;

import static org.junit.Assert.*;

import java.util.Currency;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;

public class BankAccountDAOTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateAndRetrieveAllAndDelete() {

		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount bankAccount = null;
		List<BankAccount> allAccounts = null;
		
		try {
			allAccounts = bankAccountDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all BankAccounts: "+e.getMessage());
		}
		
		try {
			bankAccount = bankAccountDAO.create();
		} catch (POMDataModelException e) {
			fail("Fail to create BankAccount: "+e.getMessage());
		}
		
		long size = allAccounts.size();
		
		try {
			allAccounts = bankAccountDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all BankAccount: "+e.getMessage());
		}
		assertNotNull(bankAccount.getId());
		assertEquals(size+1, allAccounts.size());
		
		try {
			
			bankAccountDAO.delete(bankAccount);
			
		} catch (POMDataModelException e) {
			fail("Fail to delete BankAccount: "+e.getMessage());
		}
		
		try {
			allAccounts = bankAccountDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all BankAccount: "+e.getMessage());
		}
		
		assertEquals(size, allAccounts.size());
		
	}
	
	@Test
	public void testSaveObject() {

		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount bankAccount = new BankAccount();
		
		Currency currency = Currency.getInstance("UAH");
		
		bankAccount.setCurrency(currency);
		bankAccount.setName("Name");
		bankAccount.setBankName("BankName");
		
		assertEquals(bankAccount.getId(),0);
		
		try {
			bankAccountDAO.create(bankAccount);
		} catch (POMDataModelException e) {
			fail("Fail to create BankAccount: "+e.getMessage());
		}
		
		assertNotEquals(bankAccount.getId(),0);
		
	}
	
	@Test
	public void testUpdateAndGetByID() {

		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		List<BankAccount> allAccounts = null;
		
		try {
			allAccounts = bankAccountDAO.retrieveAll();
		} catch (POMDataModelException e) {
			fail("Fail to retrieve all BankAccounts: "+e.getMessage());
		}
		
		BankAccount lastAccount = allAccounts.get(allAccounts.size()-1);
		
		Currency currency = Currency.getInstance("UAH");
		
		lastAccount.setCurrency(currency);
		lastAccount.setName("Name");
		lastAccount.setBankName("BankName");
		
		long id = lastAccount.getId();
		
		try {
			bankAccountDAO.update(lastAccount);
		} catch (POMDataModelException e) {
			fail("Fail to update BankAccount: "+e.getMessage());
		}
		
		lastAccount = null;
		
		try {
			lastAccount = bankAccountDAO.retrieveById(id);
		} catch (POMDataModelException e) {
			fail("Fail to retrieve by ID BankAccount: "+e.getMessage());
		}
		
		assertEquals(lastAccount.getId(),id);
		assertEquals(lastAccount.getCurrency(),currency);
		assertEquals(lastAccount.getName(),"Name");
		assertEquals(lastAccount.getBankName(),"BankName");
		
	}
	
}
