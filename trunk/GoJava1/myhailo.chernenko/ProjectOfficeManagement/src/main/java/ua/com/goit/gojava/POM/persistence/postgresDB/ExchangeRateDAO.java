package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.Date;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;


public class ExchangeRateDAO extends AbstractDAO<ExchangeRate> {

	private static final String CLASS_NAME = "Exchange Rate"; 
	private static final String CLASS_TABLE = "exchange_rates"; 
	private static final Logger LOG = Logger.getLogger(ExchangeRateDAO.class);
	
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
	protected ExchangeRate getNewObject() {

		return new ExchangeRate();	
	}

	@Override
	protected ExchangeRate getObjectFromRS(ResultSet rs) throws SQLException {
		
		ExchangeRate exchangeRate = getNewObject();
		
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

	@Override
	protected void setId(ExchangeRate exchangeRate, long id) {

		exchangeRate.setId(id);	
	}

	@Override
	protected Long getId(ExchangeRate exchangeRate) {
		
		return exchangeRate.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, ExchangeRate exchangeRate)
			throws SQLException {

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

		PreparedStatement statement = connection.prepareStatement(insertTableSQL);

		java.sql.Timestamp sqlTime = new java.sql.Timestamp(exchangeRate.getDate().getTime());
		
		statement.setTimestamp(1, sqlTime);
		statement.setString(2, exchangeRate.getFromCurrency().getCurrencyCode());
		statement.setString(3, exchangeRate.getToCurrency().getCurrencyCode());
		statement.setLong(4,  exchangeRate.getMultiplicity());
		statement.setLong(5,  exchangeRate.getRate());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, ExchangeRate exchangeRate)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 date = ?"
				+ " 	,from_currency = ?"
				+ " 	,to_currency = ?"
				+ " 	,multiplicity = ?"
				+ " 	,rate = ?"
				+ "	WHERE ID = ? "
			;

		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(exchangeRate.getDate().getTime());
		
		statement.setTimestamp(1, sqlTime);
		statement.setString(2, exchangeRate.getFromCurrency().getCurrencyCode());
		statement.setString(3, exchangeRate.getToCurrency().getCurrencyCode());
		statement.setLong(4,  exchangeRate.getMultiplicity());
		statement.setLong(5,  exchangeRate.getRate());
		statement.setLong(6,  exchangeRate.getId());
		
		return statement;
		
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
