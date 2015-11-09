package com.kickstarter;

import java.util.HashMap;
import java.util.Map;
import com.kickstarter.models.Payer;
import com.kickstarter.models.Project;
import com.kickstarter.storages.CategoryStorage;
import com.kickstarter.storages.PayersDataBase;

public class PaymentSystem {

	PayersDataBase pdb = new PayersDataBase();

	public void addPayer(int cardId, String holderName) {
		Map<Integer, Payer> payersList = new HashMap<>();
		payersList = pdb.getPayersList();
		payersList.put(cardId, new Payer(holderName, cardId));
		pdb.setPayersList(payersList);

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
		String holderName = UserInputReader.readString();
		return holderName;

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