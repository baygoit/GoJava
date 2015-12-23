package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Payment;

public interface PaymentDao {

	public void add(Payment element);

	public void remove(Payment element);

	public int getSumProjectPayments(int projectId);
}
