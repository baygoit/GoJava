package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.Date;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;

public class PaymentDocumentDAO extends AbstractDAO<PaymentDocument> {
	
	private static final String CLASS_NAME = "Payment Document"; 
	private static final String CLASS_TABLE = "payment_document"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDAO.class);
	
	private ua.com.goit.gojava.POM.persistence.hibernate.BankAccountDAO bankAccountDAO;
	
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
	protected PaymentDocument getNewObject() {

		return new PaymentDocument();	
	}

	@Override
	protected PaymentDocument getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		PaymentDocument paymentDocument = getNewObject();
		
		Date date = null;
		Timestamp timestamp = rs.getTimestamp("date");
		if(timestamp != null) {
			date = new Date(timestamp.getTime());
		}
		
		paymentDocument.setId(rs.getLong("ID"));
		paymentDocument.setDate(date);
		paymentDocument.setChecked(rs.getBoolean("checked"));
		paymentDocument.setDescription(rs.getString("description"));
		
		String currencyCode = rs.getString("currency");
		if(currencyCode != null) {
			Currency currency = Currency.getInstance(currencyCode);
			paymentDocument.setDocSum(new Money(rs.getDouble("sum"),currency));
		}
		
		long bankAccountId = rs.getLong("bank_account_id");
		if(bankAccountId != 0) {
			paymentDocument.setBankAccount(bankAccountDAO.retrieveById(bankAccountId));
		}
		
		return paymentDocument;
		
	}

	@Override
	protected void setId(PaymentDocument paymentDocument, long id) {

		paymentDocument.setId(id);	
	}

	@Override
	protected Long getId(PaymentDocument paymentDocument) {
		
		return paymentDocument.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, PaymentDocument paymentDocument)
			throws SQLException {
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 date "
				+ " 	,bank_account_id "
				+ " 	,checked "
				+ " 	,description "
				+ " 	,sum "
				+ " 	,currency "
				+ "	   ) "
				+ " VALUES (?,?,?,?,?,?) "
				+ "	RETURNING ID "
			;

		PreparedStatement statement = connection.prepareStatement(insertTableSQL);
		
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(paymentDocument.getDate().getTime());
		
		statement.setTimestamp(1, sqlTime);
		statement.setLong(2, paymentDocument.getBankAccount().getId());
		statement.setBoolean(3, paymentDocument.isChecked());
		statement.setString(4, paymentDocument.getDescription());
		statement.setBigDecimal(5, paymentDocument.getDocSum().getValue());
		statement.setString(6, paymentDocument.getCurrency().getCurrencyCode());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, PaymentDocument paymentDocument)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 date = ? "
				+ " 	,bank_account_id = ? "
				+ " 	,checked = ? "
				+ " 	,description = ? "
				+ " 	,sum = ? "
				+ " 	,currency = ? "
				+ "	WHERE ID = ? "
			;

		PreparedStatement statement = connection.prepareStatement(updateTableSQL);

		java.sql.Timestamp sqlTime = new java.sql.Timestamp(paymentDocument.getDate().getTime());
		
		statement.setTimestamp(1, sqlTime);
		statement.setLong(2, paymentDocument.getBankAccount().getId());
		statement.setBoolean(3, paymentDocument.isChecked());
		statement.setString(4, paymentDocument.getDescription());
		statement.setBigDecimal(5, paymentDocument.getDocSum().getValue());
		statement.setString(6, paymentDocument.getCurrency().getCurrencyCode());
		statement.setLong(7,  paymentDocument.getId());
		
		return statement;
		
	}

	public ua.com.goit.gojava.POM.persistence.hibernate.BankAccountDAO getBankAccountDAO() {
		return bankAccountDAO;
	}

	public void setBankAccountDAO(ua.com.goit.gojava.POM.persistence.hibernate.BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO = bankAccountDAO;
	}

}
