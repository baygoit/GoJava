package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.List;

public class PaymentStorage {

	private List<Payment> paymentsList = new ArrayList<>();

	public Payment getPayment(int paymentNumber) {
		return paymentsList.get(paymentNumber);
	}

	public void setPayment(Payment paymentName) {
		paymentsList.add(paymentName);
	}

}
