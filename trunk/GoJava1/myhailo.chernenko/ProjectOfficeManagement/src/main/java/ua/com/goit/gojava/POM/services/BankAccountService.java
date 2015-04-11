package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.BankAccountDAO;

public class BankAccountService {
	
	private static final String CLASS_NAME = "Bank Account"; 
	private static final Logger LOG = Logger.getLogger(BankAccountService.class);
	BankAccountDAO bankAccountDAO;

	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		
		this.bankAccountDAO = bankAccountDAO;
		
	}
	
	public List<BankAccount> retrieveAll() throws POMServicesException {
		
		try {
			return bankAccountDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s: ",e);
		}
		
	}
	
	public List<BankAccount> retrieveAll(Paginator paginator) throws POMServicesException {
		
		try {
			return bankAccountDAO.retrieveAll(paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
	}

	public BankAccount retrieveById(long id) throws POMServicesException {

		try {
			return bankAccountDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve "+CLASS_NAME+" by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve "+CLASS_NAME+" by ID",e);
		}
	}

	public void delete(BankAccount bankAccount) throws POMServicesException {

		try {
			bankAccountDAO.delete(bankAccount);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not delete "+CLASS_NAME+"",e);
		}
	}

	public void create(BankAccount bankAccount) throws POMServicesException {

		try {
			bankAccountDAO.create(bankAccount);
		} catch (POMPersistenceException e) {
			LOG.error("Could not create "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not create "+CLASS_NAME+"",e);
		}
	}

	public void update(BankAccount bankAccount) throws POMServicesException {

		try {
			bankAccountDAO.update(bankAccount);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not update "+CLASS_NAME+"",e);
		}
	}

	public List<BankAccount> findByName(String query) throws POMServicesException {

		try {
			
			Criterion restriction = Restrictions.like("name", query);
			return bankAccountDAO.retrieve(restriction);
		} catch (POMPersistenceException e) {
			LOG.error("Could not find by name "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not find by name "+CLASS_NAME+"",e);
		}
	}

}
