package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;

public class BankAccountDAO {
	
	private static final String CLASS_TABLE = "bank_account"; 
	private static final Logger LOG=Logger.getLogger(BankAccountDAO.class);
	
	private Connection getDBConnection() {
		
		return DBDataManager.getConnection();
		
	}
	
	private void closeDBConnections(ResultSet rs, Statement statement, Connection connection) {
		
		DBDataManager.CloseConnections(rs, statement, connection);
		
	}

	
	private BankAccount getObjectFromRS(ResultSet rs) throws SQLException {
		
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.setId(rs.getLong("ID"));
		String currencyCode = rs.getString("currency");
			if(currencyCode != null) {
				bankAccount.setCurrency(Currency.getInstance(currencyCode));
			}
		bankAccount.setName(rs.getString("name"));
		bankAccount.setBankName(rs.getString("bank_name"));
		
		return bankAccount;
		
	}

	public BankAccount create() throws POMDataModelException {

		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE
								+ " DEFAULT VALUES"
								+ "	RETURNING ID "
								;
		
		BankAccount bankAccount = new BankAccount();
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(insertTableSQL);
			 
			if (rs.next()) {
				
				bankAccount.setId(rs.getLong("ID"));
 				
			}
			
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not create new Bank Account: "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new Bank Account: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return bankAccount;
	
	}
	
	public BankAccount create(BankAccount bankAccount) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
										+ " 	 name "
										+ " 	,bank_name "
										+ " 	,currency "
										+ "	   ) "
										+ " VALUES (?,?,?) "
										+ "	RETURNING ID "
														;
		
		try {

			statement = connection.prepareStatement(insertTableSQL);
			statement.setString(1, bankAccount.getName());
			statement.setString(2, bankAccount.getBankName());
			statement.setString(3, bankAccount.getCurrency().getCurrencyCode());
			
			rs = statement.executeQuery();
			if (rs.next()) {
				bankAccount.setId(rs.getLong("ID"));
 			}
			
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not create new Bank Account: "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new Bank Account: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return bankAccount;
	
	}
	
	public List<BankAccount> retrieveAll() throws POMDataModelException {

		List<BankAccount> resultList = new ArrayList<BankAccount>();
		
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
				
				BankAccount bankAccount = getObjectFromRS(rs);
				
				resultList.add(bankAccount);
				
			}
			
		} catch (SQLException e) {
 
			LOG.error("Could not retrieve all Bank Accounts: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve all Bank Accounts: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return resultList;
	
	}
	
	public BankAccount retrieveById(Long id) throws POMDataModelException {

		BankAccount result = new BankAccount();
		
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
 
			LOG.error("Could not retrieve Bank Account by ID: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve Bank Account by ID: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return result;
	
	}

	public void update(BankAccount bankAccount) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "UPDATE "+CLASS_TABLE
								+ " SET "
								+ " 	 name = ? "
								+ " 	,bank_name = ? "
								+ " 	,currency = ? "
								+ "	WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(updateTableSQL);
			statement.setString(1, bankAccount.getName());
			statement.setString(2, bankAccount.getBankName());
			statement.setString(3, bankAccount.getCurrency().getCurrencyCode());
			statement.setLong(4,  bankAccount.getId());
			
			statement.execute();
				
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not update Bank Account: "+e.getMessage(), e);
			throw new POMDataModelException("Could not update Bank Account: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}
	
	public void delete(BankAccount bankAccount) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "DELETE FROM "+CLASS_TABLE
								+ "	WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(updateTableSQL);
			statement.setLong(1,  bankAccount.getId());
			
			statement.execute();
			
			bankAccount = null;
				
		} catch (SQLException e) {
 
			LOG.error("Could not delete Bank Account: "+e.getMessage(), e);
			throw new POMDataModelException("Could not delete Bank Account: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}

}
