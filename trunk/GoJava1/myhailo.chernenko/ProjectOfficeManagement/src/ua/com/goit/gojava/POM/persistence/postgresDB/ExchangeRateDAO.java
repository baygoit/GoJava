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

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;


public class ExchangeRateDAO {

	private static final String CLASS_TABLE = "exchange_rates"; 
	private static final Logger LOG=Logger.getLogger(ExchangeRateDAO.class);
	
	private Connection getDBConnection() {
		
		return DBDataManager.getConnection();
		
	}
	
	private void closeDBConnections(ResultSet rs, Statement statement, Connection connection) {
		
		DBDataManager.CloseConnections(rs, statement, connection);
		
	}

	
	private ExchangeRate getObjectFromRS(ResultSet rs) throws SQLException {
		
		ExchangeRate exchangeRate = new ExchangeRate();
		
		Date date = null;
		Timestamp timestamp = rs.getTimestamp("date");
		if(timestamp != null) {
			date = new Date(timestamp.getTime());
		}
		
		exchangeRate.setId(rs.getLong("ID"));
		exchangeRate.setDate(date);
		String currencyCode = rs.getString("from_currency");
			if(currencyCode != null) {
				exchangeRate.setFromCurrency(Currency.getInstance(currencyCode));
			}
		currencyCode = rs.getString("to_currency");
			if(currencyCode != null) {
				exchangeRate.setToCurrency(Currency.getInstance(currencyCode));
			}
		exchangeRate.setMultiplicity(rs.getLong("multiplicity"));
		exchangeRate.setRate(rs.getLong("rate"));
		
		return exchangeRate;
		
	}

	public ExchangeRate create() throws POMDataModelException {

		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE
								+ " DEFAULT VALUES"
								+ "	RETURNING ID "
								;
		
		ExchangeRate exchangeRate = new ExchangeRate();
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(insertTableSQL);
			 
			if (rs.next()) {
				
				exchangeRate.setId(rs.getLong("ID"));
 				
			}
			
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not create new Exchage Rate: "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new Exchage Rate: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return exchangeRate;
	
	}
	
	public ExchangeRate create(ExchangeRate exchangeRate) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
										+ " 	 date "
										+ " 	,from_currency "
										+ " 	,to_currency "
										+ " 	,multiplicity "
										+ " 	,rate "
										+ "	   ) "
										+ " VALUES (?,?,?,?,?) "
										+ "	RETURNING ID "
														;
		
		try {

			java.sql.Timestamp sqlTime = new java.sql.Timestamp(exchangeRate.getDate().getTime());
			
			statement = connection.prepareStatement(insertTableSQL);
			statement.setTimestamp(1, sqlTime);
			statement.setString(2, exchangeRate.getFromCurrency().getCurrencyCode());
			statement.setString(3, exchangeRate.getToCurrency().getCurrencyCode());
			statement.setLong(4,  exchangeRate.getMultiplicity());
			statement.setLong(5,  exchangeRate.getRate());
			
			rs = statement.executeQuery();
			if (rs.next()) {
				exchangeRate.setId(rs.getLong("ID"));
 			}
			
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not create new Exchage Rate: "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new Exchage Rate: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return exchangeRate;
	
	}
	
	public List<ExchangeRate> retrieveAll() throws POMDataModelException {

		List<ExchangeRate> resultList = new ArrayList<ExchangeRate>();
		
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
				
				ExchangeRate exchangeRate = getObjectFromRS(rs);
				
				resultList.add(exchangeRate);
				
			}
			
		} catch (SQLException e) {
 
			LOG.error("Could not retrieve all Exchage Rates: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve all Exchage Rates: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return resultList;
	
	}
	
	public ExchangeRate retrieveById(Long id) throws POMDataModelException {

		ExchangeRate result = new ExchangeRate();
		
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
 
			LOG.error("Could not retrieve Exchage Rate by ID: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve Exchage Rate by ID: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return result;
	
	}

	public void update(ExchangeRate exchangeRate) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "UPDATE "+CLASS_TABLE
								+ " SET "
								+ " 	 date = ?"
								+ " 	,from_currency = ?"
								+ " 	,to_currency = ?"
								+ " 	,multiplicity = ?"
								+ " 	,rate = ?"
								+ "	WHERE ID = ? "
								;
		
		try {

			java.sql.Timestamp sqlTime = new java.sql.Timestamp(exchangeRate.getDate().getTime());
			
			statement = connection.prepareStatement(updateTableSQL);
			statement.setTimestamp(1, sqlTime);
			statement.setString(2, exchangeRate.getFromCurrency().getCurrencyCode());
			statement.setString(3, exchangeRate.getToCurrency().getCurrencyCode());
			statement.setLong(4,  exchangeRate.getMultiplicity());
			statement.setLong(5,  exchangeRate.getRate());
			statement.setLong(6,  exchangeRate.getId());
			
			statement.execute();
				
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not update Exchage Rate: "+e.getMessage(), e);
			throw new POMDataModelException("Could not update Exchage Rate: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}
	
	public void delete(ExchangeRate exchangeRate) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "DELETE FROM "+CLASS_TABLE
								+ "	WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(updateTableSQL);
			statement.setLong(1,  exchangeRate.getId());
			
			statement.execute();
			
			exchangeRate = null;
				
		} catch (SQLException e) {
 
			LOG.error("Could not delete Exchage Rate: "+e.getMessage(), e);
			throw new POMDataModelException("Could not delete Exchage Rate: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}

	public ExchangeRate getLastOnDate(Date date, Currency fromCurrency, Currency toCurrency) {

		// TODO rewrite it
		/*
		
		List<ExchangeRate> list = getList();
		Date lastDate = null; // instead of sorting...
		ExchangeRate findedExchangeRate = null;
		
		for(ExchangeRate exchangeRate : list) {
			if((exchangeRate.getFromCurrency() == fromCurrency)
					&&(exchangeRate.getToCurrency() == toCurrency)
					&&( (exchangeRate.getDate().before(date))
						 || (exchangeRate.getDate().equals(date))	)
					&&( (lastDate == null)
							 || (lastDate.before(exchangeRate.getDate()))	)){
				findedExchangeRate = exchangeRate;
				lastDate = exchangeRate.getDate();
			}
		} */
	
		return null;

	}

}
