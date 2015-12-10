package com.kickstarter.manager;


import java.util.HashMap;
import java.util.Map;

import com.kickstarter.dao.ProjectDao;
import com.kickstarter.memory.storage.PayersDB;
import com.kickstarter.model.Payer;
import com.kickstarter.model.Project;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class PaymentSystem {
	
	ConsolePrintView consolePrintView = new ConsolePrintView();
	PayersDB pdb = new PayersDB();
	ProjectDao projectDao = new ProjectDao();

	public void addPayer(int cardId, String holderName) {

		Map<Integer, Payer> payersList = new HashMap<>();
		payersList = pdb.getPayersList();
		payersList.put(cardId, new Payer(holderName, cardId));
		pdb.setPayersList(payersList);

	}

	public void acceptPayment(int payment, Project p) {
//		Map<Integer, Project> allProjects = prm.getWholeProjectMap();
		int lastGainedSum = p.getGainedSum();
		p.setGainedSum(lastGainedSum += payment);
		projectDao.update(p);
//		allProjects.put(projectNumber, p);
//		writeToFile(allProjects);
	}

	public void makePayment(Project p) {
		int kind = acceptKindOfPayment();
		String holderName = acceptPayerName();
		int cardId = acceptPayercardId();
		int payment = providePaymentKind(kind);
		addPayer(cardId, holderName);
		acceptPayment(payment, p);
	}

	public int providePaymentKind(int kind) {
		int payment;
		if (kind == 1) {
			payment = 50;
			return payment;
		} else if (kind == 2) {
			payment = 100;
			return payment;
		} else if (kind == 3) {
			payment = 150;
			return payment;
		} else {
			payment = acceptPayment();
			return payment;
		}

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

	public int acceptKindOfPayment() {
		consolePrintView.paymentSizeInfo();
		int kind = UserConsoleInputReader.readInput();
		return kind;
	}

//	public void writeToFile(Map<Integer, Project> list) {
//		File file = new File("project.txt");
//		try (PrintWriter pw = new PrintWriter(file)) {
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//			for (Project p : list.values()) {
//				pw.println(p.getId());
//				pw.println(p.getTitle());
//				pw.println(p.getDiscription());
//				pw.println(p.getDaysLeft());
//				pw.println(p.getRequiredSum());
//                pw.println(p.getGainedSum());
//                pw.println(p.getProjectHistory());
//                pw.println(p.getVideoLink());
//                pw.println(p.getCategoryName());
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
}