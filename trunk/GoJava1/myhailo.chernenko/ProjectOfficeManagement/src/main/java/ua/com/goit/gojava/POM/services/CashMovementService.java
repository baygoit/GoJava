package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.CashMovementDAO;

public class CashMovementService {
	
	private static final String CLASS_NAME = "Cash Movement"; 
	private static final Logger LOG = Logger.getLogger(CashMovementService.class);
	CashMovementDAO cashMovementDAO;

	public void setCashMovementDAO(CashMovementDAO cashMovementDAO) {
		
		this.cashMovementDAO = cashMovementDAO;
		
	}
	
	public Money getTotalByBankAccount(BankAccount bankAccount) throws POMServicesException {
		
		try {
			return cashMovementDAO.getTotalByBankAccount(bankAccount);
		} catch (POMPersistenceException e) {
			LOG.error("Could not get total by "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not get total by "+CLASS_NAME+"",e);
		}
		
	}

	public List<CashMovementEntry> retrieveAll() throws POMServicesException {

		try {
			return cashMovementDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	
	public List<CashMovementEntry> retrieveAll(BankAccount bankAccount) throws POMServicesException {

		try {
			return cashMovementDAO.retrieveAll(bankAccount);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	
	public CashMovementEntry retrieveById(long id) throws POMServicesException {

		try {
			return cashMovementDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve "+CLASS_NAME+" by id: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve "+CLASS_NAME+" by id",e);
		}
		
	}

	public void delete(CashMovementEntry cashMovementEntry) throws POMServicesException {

		try {
			cashMovementDAO.delete(cashMovementEntry);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not delete "+CLASS_NAME+"",e);
		}
		
	}

	public void create(CashMovementEntry newEntry) throws POMServicesException {

		try {
			cashMovementDAO.create(newEntry);
		} catch (POMPersistenceException e) {
			LOG.error("Could not create "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not create "+CLASS_NAME+"",e);
		}
		
	}

	public void update(CashMovementEntry cashMovementEntry) throws POMServicesException {

		try {
			cashMovementDAO.update(cashMovementEntry);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not update "+CLASS_NAME+"",e);
		}
		
	}

	public void deleteAllByDoc(FinancialDocument doc) throws POMServicesException {

		try {
			cashMovementDAO.deleteAllByDoc(doc);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete all "+CLASS_NAME+"s by doc: "+e.getMessage(), e);
			throw new POMServicesException("Could not delete all "+CLASS_NAME+"s by doc",e);
		}
		
	}

}
