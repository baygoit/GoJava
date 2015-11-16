package com.kickstarter.manager;

import java.util.HashMap;
import java.util.Map;

import com.kickstarter.app.Kickstarter;
import com.kickstarter.db.PayersDB;
import com.kickstarter.model.Payer;
import com.kickstarter.model.Project;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class PaymentSystem {

	ConsolePrintView consolePrintView = new ConsolePrintView();
	PayersDB pdb = new PayersDB();
	ProjectManager prm = new ProjectManager();

	public void addPayer(int cardId, String holderName) {

		Map<Integer, Payer> payersList = new HashMap<>();
		payersList = pdb.getPayersList();
		payersList.put(cardId, new Payer(holderName, cardId));
		pdb.setPayersList(payersList);

	}

	public void acceptPayment(int payment, int projectNumber, String categoryTitle) {
		Project p = prm.getProject(categoryTitle, projectNumber);
		int lastGainedSum = p.getGainedSum();
		p.setGainedSum(lastGainedSum += payment);

	}

	public void makePayment(int projectNumber, int categoryNumber, String categoryTitle) {
		String holderName = acceptPayerName();
		int cardId = acceptPayercardId();
		int payment = acceptPayment();
		addPayer(cardId, holderName);
		acceptPayment(payment, projectNumber, categoryTitle);
	    consolePrintView.singleCategorysProjectsView(prm.getProject(categoryTitle, projectNumber));
    	Kickstarter.projectSelector(categoryNumber, categoryTitle);
	}

	public String acceptPayerName() {
		
		consolePrintView.InputPayersNameInfo();
		return UserConsoleInputReader.readStringInput();

	}

	public int acceptPayercardId() {
		consolePrintView.InputCardIdInfo();
		int cardId = UserConsoleInputReader.readInput();
		return cardId;

	}

	public int acceptPayment() {
		consolePrintView.paymentSizeInfo();
		int payment = UserConsoleInputReader.readInput();
		return payment;
	}

}