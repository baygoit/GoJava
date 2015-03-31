package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class BankAccountDAO extends AbstractDAO<BankAccount> {
	
	private static final String CLASS_NAME = "Bank Account"; 
	private static final String CLASS_TABLE = "bank_account"; 
	private static final Logger LOG = Logger.getLogger(BankAccountDAO.class);
	
	public BankAccountDAO() {
		super(BankAccount.class);
	}

	@Override
	protected String getClassName() {		
		return CLASS_NAME;
	}

	@Override
	protected String getClassTable() {
		return CLASS_TABLE;
	}

	@Override
	protected Logger getLog() {	
		return LOG;	
	}

	@Override
	protected BankAccount getNewObject() {
		return new BankAccount();	
	}

}
