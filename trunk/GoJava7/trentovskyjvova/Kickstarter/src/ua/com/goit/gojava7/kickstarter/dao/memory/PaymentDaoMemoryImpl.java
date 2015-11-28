package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentDaoMemoryImpl implements PaymentDao {
	private List<Payment> payments;

	@Override
	public List<Payment> getPayments(int projectId) {
		if(payments != null){
			return payments;
		}
		payments = new ArrayList<>();
		
		Payment payment1 = new Payment();
		payment1.setId(1);
		payment1.setProjectId(1);
		payment1.setName("Julio");
		payment1.setPledge(30);
		payments.add(payment1);

		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public void addPayment(Payment payment) {
		payment.setId(generateIdOfNewElement());
		payments.add(payment);
	}

	@Override
	public int getPledged(int projectId) {		
		cachePayments(projectId);
		
		int pledged = 0;
		for (Payment payment : payments) {
			if (payment.getProjectId() == projectId) {
				pledged += payment.getPledge();
			}
		}
		return pledged;
	}
	
	private int generateIdOfNewElement() {
		cachePayments(0);
		
		int maxId = 0;
		for (Payment payment : payments) {
			if (maxId < payment.getId()) {
				maxId = payment.getId();
			}
		}
		return maxId + 1;
	}
	
	private void cachePayments(int projectId){
		if(payments == null){
			getPayments(projectId);
		}
	}
}
