package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.PaymentReader;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class MemoryPaymentReader implements PaymentReader {

	@Override
	public List<Payment> readPayments() {
		List<Payment> payments = new ArrayList<>();
		
		Payment payment1 = new Payment(1);
		payment1.setProjectId(1);
		payment1.setName("Julio");
		payment1.setPledge(30);
		payments.add(payment1);
		
		return payments;
	}

}
