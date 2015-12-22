package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Payment;

@Component
public class PaymentDbDao{
	//TODO

	//private static final String TABLE = "payment";
	//private static final String FIELDS = "id, user, card, amount, project_id";

	public PaymentDbDao() {		
	}
	
	
	public Payment readElement(ResultSet resultSet) throws SQLException {
		return null;
	}

}
