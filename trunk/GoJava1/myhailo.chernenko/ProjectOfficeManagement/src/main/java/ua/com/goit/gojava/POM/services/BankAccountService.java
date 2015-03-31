package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.hibernate.BankAccountDAO;

public class BankAccountService {
	
	BankAccountDAO bankAccountDAO;

	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		
		this.bankAccountDAO = bankAccountDAO;
		
	}
	
	public List<BankAccount> retrieveAll() throws POMDataModelException {
		
		return bankAccountDAO.retrieveAll();
		
	}

	public BankAccount retrieveById(long id) throws POMDataModelException {

		return bankAccountDAO.retrieveById(id);
		
	}

	public void delete(BankAccount bankAccount) throws POMDataModelException {

		bankAccountDAO.delete(bankAccount);
		
	}

	public void create(BankAccount bankAccount) throws POMDataModelException {

		bankAccountDAO.create(bankAccount);
		
	}

	public void update(BankAccount bankAccount) throws POMDataModelException {

		bankAccountDAO.update(bankAccount);
		
	}

}
