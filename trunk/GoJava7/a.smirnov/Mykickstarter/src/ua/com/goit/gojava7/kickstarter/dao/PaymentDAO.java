package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public interface PaymentDAO {
	
	public void add(Payment payment);

	public void remove(Payment payment);
	
	public List<Payment> getAll();
	
	public int getSize();

	public int getSumProjectPayments(Project project);
	
}
