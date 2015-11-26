package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public abstract class AbstractPaymentDao {
	
	public final String SEMICOLON_DELIMITER = ";";
	public final String NEW_LINE_SEPARATOR = "\n";
	
	public final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	public final String USER_NAME = "root";
	public final String PASSWORD = "root";
	
	public abstract void add(Payment element);

	public abstract void remove(Payment element);
	
	public abstract List<Payment> getAll();
	
	public abstract int getSize();
	
	public abstract int getSumProjectPayments(Project project);
	
}
