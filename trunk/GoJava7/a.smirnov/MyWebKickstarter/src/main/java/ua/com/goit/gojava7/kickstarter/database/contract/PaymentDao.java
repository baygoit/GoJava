package ua.com.goit.gojava7.kickstarter.database.contract;

import ua.com.goit.gojava7.kickstarter.beans.Payment;

public interface PaymentDao {

	public void add(Payment element);

	public void remove(Payment element);

	public long getSumProjectPayments(int projectId);
}
