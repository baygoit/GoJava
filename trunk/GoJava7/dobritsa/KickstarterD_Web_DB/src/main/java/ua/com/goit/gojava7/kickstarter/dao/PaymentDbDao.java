package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.DbDao;
import ua.com.goit.gojava7.kickstarter.models.Payment;

@Component
public class PaymentDbDao extends DbDao<Payment> {

	private static final String TABLE = "payment";
	private static final String FIELDS = "id, user, card, amount, project_id";

	public PaymentDbDao() {	
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public PaymentDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	@Override
	public Payment readElement(ResultSet resultSet) throws SQLException {
		return null;
	}

}
