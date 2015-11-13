package ua.com.goit.gojava7.kickstarter;

import java.util.HashMap;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Payer;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.PayersDataBase;

public class PaymentSystem {

	PayersDataBase pdb = new PayersDataBase();

	public void addPayer(int cardId, String holderName) {
		System.out.println(pdb.getPayersList().size());
		Map<Integer, Payer> payersList = new HashMap<>();
		payersList = pdb.getPayersList();
		payersList.put(cardId, new Payer(holderName, cardId));
		pdb.setPayersList(payersList);
		System.out.println(pdb.getPayersList().size());
	}

	public void acceptPayment(int payment, int projectNumber, int categoryNumber) {
		Project p = CategoryStorage.getCategoriesByNumber(categoryNumber).getProjectList().get(projectNumber);
		int lastGainedSum = p.getGainedSum();
		p.setGainedSum(lastGainedSum += payment);

	}

	public void makePayment(int projectNumber, int categoryNumber) {
		PaymentSystem ps = new PaymentSystem();
		String holderName = acceptPayerName();
		int cardId = acceptPayercardId();
		int payment = acceptPayment();
		ps.addPayer(cardId, holderName);
		ps.acceptPayment(payment, projectNumber, categoryNumber);
		Printer.projectInform(projectNumber, categoryNumber);
		Kickstarter.project(categoryNumber);
	}

	public String acceptPayerName() {
		Printer.payerNameGet();

		return UserInputReader.readString();

	}

	public int acceptPayercardId() {
		Printer.payerCardIdGet();
		int cardId = UserInputReader.read();
		return cardId;

	}

	public int acceptPayment() {
		Printer.paymentOffer();
		int payment = UserInputReader.read();
		return payment;
	}

}