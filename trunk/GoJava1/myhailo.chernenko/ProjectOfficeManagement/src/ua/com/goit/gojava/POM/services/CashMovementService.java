package ua.com.goit.gojava.POM.services;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.postgresDB.CashMovementDAO;

public class CashMovementService {
	
	CashMovementDAO cashMovementDAO;

	public void setCashMovementDAO(CashMovementDAO cashMovementDAO) {
		
		this.cashMovementDAO = cashMovementDAO;
		
	}
	
	public Money getTotalByBankAccount(BankAccount bankAccount) throws POMDataModelException {
		
		return cashMovementDAO.getTotalByBankAccount(bankAccount);
		
	}

}
