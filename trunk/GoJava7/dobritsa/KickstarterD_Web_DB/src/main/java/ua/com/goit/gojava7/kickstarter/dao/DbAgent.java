package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class DbAgent {

	private static final Logger log = LoggerFactory.getLogger(DbAgent.class);

	public DbAgent() {
		log.info("Constructor DbAgent()...");
	}		
	
	

	public int readSumPaymentsByProject(ResultSet resultSet) throws SQLException {
		log.info("<int> readSumPaymentsByProject({})...");
		return resultSet.getInt("sum");
	}
}
