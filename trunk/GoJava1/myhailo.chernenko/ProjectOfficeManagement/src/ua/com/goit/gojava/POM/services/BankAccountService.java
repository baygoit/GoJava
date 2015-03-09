package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.postgresDB.BankAccountDAO;

public class BankAccountService {
	
	BankAccountDAO bankAccountDAO;

	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		
		this.bankAccountDAO = bankAccountDAO;
		
	}
	
	public List<BankAccount> retrieveAll() throws POMDataModelException {
		
		return bankAccountDAO.retrieveAll();
		
	}

}
