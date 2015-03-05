package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.Money;


public class CashMovementDAO {
	
	private static final String CLASS_TABLE = "cash_movement"; 

	private Connection getDBConnection() {
		
		return DBDataManager.getConnection();
		
	}
	
	private void closeDBConnections(ResultSet rs, Statement statement, Connection connection) {
		
		DBDataManager.CloseConnections(rs, statement, connection);
		
	}

	
	private CashMovementEntry getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		CashMovementEntry cashMovementEntry = new CashMovementEntry();
		
		cashMovementEntry.setId(rs.getLong("ID"));
		
		Date date = null;
		Timestamp timestamp = rs.getTimestamp("date");
		if(timestamp != null) {
			date = new Date(timestamp.getTime());
		}
		cashMovementEntry.setDate(date);
		
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		long accountId= rs.getLong("bank_account_id");
		cashMovementEntry.setBankAccount(bankAccountDAO.retrieveById(accountId));;
		
		Currency currency = null;
		String currencyCode = rs.getString("currency");
			if(currencyCode != null) {
				currency = Currency.getInstance(currencyCode);
			}

		cashMovementEntry.setSum(new Money(rs.getDouble("sum"), currency));;
		
		return cashMovementEntry;
		
	}

	public CashMovementEntry create() throws POMDataModelException {

		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE
								+ " DEFAULT VALUES"
								+ "	RETURNING ID "
								;
		
		CashMovementEntry cashMovementEntry = new CashMovementEntry();
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(insertTableSQL);
			 
			if (rs.next()) {
				
				cashMovementEntry.setId(rs.getLong("ID"));
 				
			}
			
		} catch (SQLException | NullPointerException e) {
 
			throw new POMDataModelException("Could not create new Cash Movement Entry: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return cashMovementEntry;
	
	}
	
	public CashMovementEntry create(CashMovementEntry cashMovementEntry) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
										+ " 	 date "
										+ " 	,bank_account_id "
										+ " 	,sum "
										+ " 	,currency "
										+ "	   ) "
										+ " VALUES (?,?,?,?) "
										+ "	RETURNING ID "
														;
		
		try {

			java.sql.Timestamp sqlTime = new java.sql.Timestamp(cashMovementEntry.getDate().getTime());
			Money sum = cashMovementEntry.getSum();
			
			statement = connection.prepareStatement(insertTableSQL);
			statement.setTimestamp(1, sqlTime);
			statement.setLong(2, cashMovementEntry.getBankAccount().getId());
			statement.setDouble(3, sum.getValue().doubleValue());
			statement.setString(4, sum.getCurrency().getCurrencyCode());
			
			rs = statement.executeQuery();
			if (rs.next()) {
				cashMovementEntry.setId(rs.getLong("ID"));
 			}
			
		} catch (SQLException | NullPointerException e) {
 
			throw new POMDataModelException("Could not create new Cash Movement Entry: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return cashMovementEntry;
	
	}
	
	public List<CashMovementEntry> retrieveAll() throws POMDataModelException {

		List<CashMovementEntry> resultList = new ArrayList<CashMovementEntry>();
		
		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = "SELECT * FROM "+CLASS_TABLE
							   +" ORDER BY ID"
								;
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(selectTableSQL);
			 
			while (rs.next()) {
				
				CashMovementEntry cashMovementEntry = getObjectFromRS(rs);
				
				resultList.add(cashMovementEntry);
				
			}
			
		} catch (SQLException e) {
 
			throw new POMDataModelException("Could not retrieve all Cash Movement Entries: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return resultList;
	
	}
	
	public CashMovementEntry retrieveById(Long id) throws POMDataModelException {

		CashMovementEntry result = new CashMovementEntry();
		
		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = " SELECT * FROM "+CLASS_TABLE
							  + " WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(selectTableSQL);
			statement.setLong(1, id);
			rs = statement.executeQuery();
			 
			if (rs.next()) {
				
				result = getObjectFromRS(rs);
				
			}
			
		} catch (SQLException e) {
 
			throw new POMDataModelException("Could not retrieve Cash Movement Entry by ID: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return result;
	
	}

	public void update(CashMovementEntry cashMovementEntry) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "UPDATE "+CLASS_TABLE
								+ " SET "
								+ " 	 date = ? "
								+ " 	,bank_account_id = ? "
								+ " 	,sum = ? "
								+ " 	,currency = ? "
								+ "	WHERE ID = ? "
								;
		
		try {

			java.sql.Timestamp sqlTime = new java.sql.Timestamp(cashMovementEntry.getDate().getTime());
			Money sum = cashMovementEntry.getSum();
			
			statement = connection.prepareStatement(updateTableSQL);
			statement.setTimestamp(1, sqlTime);
			statement.setLong(2, cashMovementEntry.getBankAccount().getId());
			statement.setDouble(3, sum.getValue().doubleValue());
			statement.setString(4, sum.getCurrency().getCurrencyCode());
			
			statement.setLong(5,  cashMovementEntry.getId());
			
			statement.execute();
				
		} catch (SQLException | NullPointerException e) {
 
			throw new POMDataModelException("Could not update Cash Movement Entry: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}
	
	public void delete(CashMovementEntry cashMovementEntry) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "DELETE FROM "+CLASS_TABLE
								+ "	WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(updateTableSQL);
			statement.setLong(1,  cashMovementEntry.getId());
			
			statement.execute();
			
			cashMovementEntry = null;
				
		} catch (SQLException e) {
 
			throw new POMDataModelException("Could not delete Cash Movement Entry: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}

}
