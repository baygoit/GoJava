package main.ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import main.ua.com.goit.gojava7.kickstarter.beans.Payment;

public interface PaymentDao {
	
	public void add(Payment element);

	public void remove(Payment element);
	
	public List<Payment> getAll();
	
	public int getSize();
	
	public int getSumProjectPayments(int projectId);
}
