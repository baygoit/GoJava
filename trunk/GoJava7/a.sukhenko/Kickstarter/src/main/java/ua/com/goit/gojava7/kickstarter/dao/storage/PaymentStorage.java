package ua.com.goit.gojava7.kickstarter.dao.storage;

import ua.com.goit.gojava7.kickstarter.domain.Payment;

public interface PaymentStorage extends Storage<Payment>{
	public Payment getById(int id);
}
