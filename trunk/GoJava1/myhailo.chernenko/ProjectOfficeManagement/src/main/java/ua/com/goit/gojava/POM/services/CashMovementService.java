package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
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

	public List<CashMovementEntry> retrieveAll() throws POMDataModelException {

		return cashMovementDAO.retrieveAll();
		
	}
	
	public List<CashMovementEntry> retrieveAll(BankAccount bankAccount) throws POMDataModelException {

		return cashMovementDAO.retrieveAll(bankAccount);
		
	}
	
	public CashMovementEntry retrieveById(long id) throws POMDataModelException {

		return cashMovementDAO.retrieveById(id);
		
	}

	public void delete(CashMovementEntry cashMovementEntry) throws POMDataModelException {

		cashMovementDAO.delete(cashMovementEntry);
		
	}

	public void create(CashMovementEntry newEntry) throws POMDataModelException {

		cashMovementDAO.create(newEntry);
		
	}

	public void update(CashMovementEntry cashMovementEntry) throws POMDataModelException {

		cashMovementDAO.update(cashMovementEntry);
		
	}

	public void deleteAllByDoc(FinancialDocument doc) throws POMDataModelException {

		cashMovementDAO.deleteAllByDoc(doc);
		
	}

}
