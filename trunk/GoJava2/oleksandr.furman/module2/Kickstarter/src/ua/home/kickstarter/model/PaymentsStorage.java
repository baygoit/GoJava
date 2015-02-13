package ua.home.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.content.Payment;

public class PaymentsStorage {

	private List<Payment> paymentsList;

	public void addProjectsPayment(Payment payment) {
		paymentsList = new ArrayList<Payment>();
		
		paymentsList.add(payment);
		
	}

	public void setPaymentToProject(Project project) {
		project.setPayment(paymentsList);
	}

	public void addNewPayment(String name, String cardNumber, int amount, Project project) {
		Payment payment = new Payment(name, cardNumber, amount);
		addProjectsPayment(payment);
		setPaymentToProject(project);
		
	}
}
