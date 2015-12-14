package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@Component
public class PaymentDbDao extends DbDao<Payment> implements PaymentDao {

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
	protected Payment readElement(ResultSet resultSet) throws SQLException {
		return null;
	}

	public boolean validateCard(String card) {
		Pattern p = Pattern.compile("^[0-9]{13,16}$");
		Matcher m = p.matcher(card);
		return m.matches();
	}

	public boolean validateName(String name) {
		Pattern p = Pattern.compile("^[a-zA-Z][a-z]{2,15}$");
		Matcher m = p.matcher(name);
		return m.matches();
	}

	public boolean validateAmount(int amount) {
		if (amount > 0)
			return true;
		else
			return false;
	}

}
