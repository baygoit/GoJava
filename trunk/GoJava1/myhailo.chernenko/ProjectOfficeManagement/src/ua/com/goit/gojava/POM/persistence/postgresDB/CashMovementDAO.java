package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.BankAccountService;


public class CashMovementDAO extends AbstractDAO<CashMovementEntry> {
	
	private static final String CLASS_NAME = "Cash Movement"; 
	private static final String CLASS_TABLE = "cash_movement"; 
	private static final Logger LOG = Logger.getLogger(CashMovementDAO.class);
	
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
	protected CashMovementEntry getNewObject() {

		return new CashMovementEntry();	
	}

	@Override
	protected CashMovementEntry getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		CashMovementEntry cashMovementEntry = getNewObject();
		
		cashMovementEntry.setId(rs.getLong("ID"));
		
		Date date = null;
		Timestamp timestamp = rs.getTimestamp("date");
		if(timestamp != null) {
			date = new Date(timestamp.getTime());
		}
		cashMovementEntry.setDate(date);
		
		BankAccountService bankAccountServise = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
		long accountId= rs.getLong("bank_account_id");
		cashMovementEntry.setBankAccount(bankAccountServise.retrieveById(accountId));;
		
		Currency currency = null;
		String currencyCode = rs.getString("currency");
			if(currencyCode != null) {
				currency = Currency.getInstance(currencyCode);
			}

		cashMovementEntry.setSum(new Money(rs.getDouble("sum"), currency));;
		
		return cashMovementEntry;
		
	}

	@Override
	protected void setId(CashMovementEntry cashMovementEntry, long id) {

		cashMovementEntry.setId(id);	
	}

	@Override
	protected Long getId(CashMovementEntry cashMovementEntry) {
		
		return cashMovementEntry.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, CashMovementEntry cashMovementEntry)
			throws SQLException {

		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 date "
				+ " 	,bank_account_id "
				+ " 	,sum "
				+ " 	,currency "
				+ "	   ) "
				+ " VALUES (?,?,?,?) "
				+ "	RETURNING ID "
			;

		PreparedStatement statement = connection.prepareStatement(insertTableSQL);

		java.sql.Timestamp sqlTime = new java.sql.Timestamp(cashMovementEntry.getDate().getTime());
		Money sum = cashMovementEntry.getSum();
		
		statement.setTimestamp(1, sqlTime);
		statement.setLong(2, cashMovementEntry.getBankAccount().getId());
		statement.setDouble(3, sum.getValue().doubleValue());
		statement.setString(4, sum.getCurrency().getCurrencyCode());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, CashMovementEntry cashMovementEntry)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 date = ? "
				+ " 	,bank_account_id = ? "
				+ " 	,sum = ? "
				+ " 	,currency = ? "
				+ "	WHERE ID = ? "
			;

		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(cashMovementEntry.getDate().getTime());
		Money sum = cashMovementEntry.getSum();
		
		statement.setTimestamp(1, sqlTime);
		statement.setLong(2, cashMovementEntry.getBankAccount().getId());
		statement.setDouble(3, sum.getValue().doubleValue());
		statement.setString(4, sum.getCurrency().getCurrencyCode());
		
		statement.setLong(5,  cashMovementEntry.getId());
		
		return statement;
		
	}

	public Money getTotalByBankAccount(BankAccount bankAccount) throws POMDataModelException {

		Money result = new Money(bankAccount.getCurrency());
		
		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = "SELECT "
							   + "	SUM(SUM) FROM "+CLASS_TABLE
							   + " WHERE bank_account_id = ? "
							  ;
		
		try {

			statement = connection.prepareStatement(selectTableSQL);
			statement.setLong(1, bankAccount.getId());
			rs = statement.executeQuery();
			 
			if (rs.next()) {
				
				result = new Money(rs.getDouble("sum"), bankAccount.getCurrency());
				
			}
			
		} catch (SQLException e) {
 
			LOG.error("Could not calculate sum of Cash Movement Entries: "+e.getMessage(), e);
			throw new POMDataModelException("Could not calculate sum of Cash Movement Entries: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return result;
	
	}
	
	public List<CashMovementEntry> retrieveAll(BankAccount bankAccount) throws POMDataModelException {

		List<CashMovementEntry> resultList = new ArrayList<CashMovementEntry>();
		
		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = "SELECT * FROM "+CLASS_TABLE
							 + " WHERE bank_account_id = ? "
						     + " ORDER BY ID"
								;
		
		try {

			statement = connection.prepareStatement(selectTableSQL);
			statement.setLong(1, bankAccount.getId());
			rs = statement.executeQuery();
			 
			while (rs.next()) {
				
				CashMovementEntry cashMovementEntry = getObjectFromRS(rs);
				
				resultList.add(cashMovementEntry);
				
			}
			
		} catch (SQLException e) {
 
			LOG.error("Could not retrieve all Cash Movement Entries: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve all Cash Movement Entries: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return resultList;
	
	}
}
