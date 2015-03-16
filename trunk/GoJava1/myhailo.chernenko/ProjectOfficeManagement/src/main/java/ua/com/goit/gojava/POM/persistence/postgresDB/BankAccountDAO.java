package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;

public class BankAccountDAO extends AbstractDAO<BankAccount> {
	
	private static final String CLASS_NAME = "Bank Account"; 
	private static final String CLASS_TABLE = "bank_account"; 
	private static final Logger LOG = Logger.getLogger(BankAccountDAO.class);
	
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

	@Override
	protected BankAccount getObjectFromRS(ResultSet rs) throws SQLException {
		
		BankAccount bankAccount = getNewObject();
		
		bankAccount.setId(rs.getLong("ID"));
		String currencyCode = rs.getString("currency");
			if(currencyCode != null) {
				bankAccount.setCurrency(Currency.getInstance(currencyCode));
			}
		bankAccount.setName(rs.getString("name"));
		bankAccount.setBankName(rs.getString("bank_name"));
		
		return bankAccount;
		
	}

	@Override
	protected void setId(BankAccount bankAccount, long id) {

		bankAccount.setId(id);	
	}

	@Override
	protected Long getId(BankAccount bankAccount) {
		
		return bankAccount.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, BankAccount bankAccount)
			throws SQLException {

		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 name "
				+ " 	,bank_name "
				+ " 	,currency "
				+ "	   ) "
				+ " VALUES (?,?,?) "
				+ "	RETURNING ID "
			;

		PreparedStatement statement = connection.prepareStatement(insertTableSQL);
		statement.setString(1, bankAccount.getName());
		statement.setString(2, bankAccount.getBankName());
		statement.setString(3, bankAccount.getCurrency().getCurrencyCode());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, BankAccount bankAccount)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 name = ? "
				+ " 	,bank_name = ? "
				+ " 	,currency = ? "
				+ "	WHERE ID = ? "
			;

		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		statement.setString(1, bankAccount.getName());
		statement.setString(2, bankAccount.getBankName());
		statement.setString(3, bankAccount.getCurrency().getCurrencyCode());
		statement.setLong(4,  bankAccount.getId());
		
		return statement;
		
	}

}
