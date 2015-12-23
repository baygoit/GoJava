package ua.com.goit.gojava7.kickstarter.DAO;

import ua.com.goit.gojava7.kickstarter.model.Payment;

public abstract class AbstractPaymentStorage implements Storage<Payment>{
	
	public abstract int getSummaryProjectCostsCollected(int idProject);

}
