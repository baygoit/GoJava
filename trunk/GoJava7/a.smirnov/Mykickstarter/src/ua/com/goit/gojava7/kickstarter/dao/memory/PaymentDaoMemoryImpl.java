package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractPaymentDao;

public class PaymentDaoMemoryImpl extends AbstractPaymentDao {

	private List<Payment> payments = new ArrayList<>();
	
	@Override
	public void add(Payment payment) {
		payments.add(payment);
	}

	@Override
	public void remove(Payment payment) {
		payments.remove(payment);
	}

	@Override
	public List<Payment> getAll() {
		return payments;
	}

	@Override
	public int getSize() {
		return payments.size();
	}
	
	@Override
	public int getSumProjectPayments(Project project) {
		List<Payment> projectPayments = new ArrayList<>();
		
		for (Payment payment : payments) {
			if (payment.getProjectID() == project.getUniqueID()) {
				projectPayments.add(payment);
			}
		}
		
		if (projectPayments.isEmpty()) {
			return 0;
		} else {	
			int sumPayments = 0;		
			for (Payment payment : projectPayments) {
				sumPayments += payment.getDonatingSum();
			}	
			return sumPayments;
		}
	}
}
