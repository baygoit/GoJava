package ua.com.goit.gojava7.kickstarter.DAO.memoryStorages;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.model.Payment;

public class PaymentStorage extends AbstractPaymentStorage {

	public static int idGenerator = 0;
	private List<Payment> payments;

	public PaymentStorage() {
		payments = new ArrayList<>();
	}
	
	public int getSummaryProjectCostsCollected(int idProject) {
		int costsCollected = 0;
		for (Payment payment : payments) {
			if (payment.getIdParentProject() == idProject) {
				costsCollected += payment.getRechargeAmount();
			}
		}
		return costsCollected;
	}

	@Override
	public List<Payment> getAll() {
		return payments;
	}

	@Override
	public void add(Payment payment) {
		payment.setIdPayment(++idGenerator);
		payments.add(payment);
		
	}
}
