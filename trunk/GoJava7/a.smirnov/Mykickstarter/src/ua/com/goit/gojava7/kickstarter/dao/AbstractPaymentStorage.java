package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public abstract class AbstractPaymentStorage implements Storage<Payment> {
	
	public abstract int getSumProjectPayments(Project project);
	
}
