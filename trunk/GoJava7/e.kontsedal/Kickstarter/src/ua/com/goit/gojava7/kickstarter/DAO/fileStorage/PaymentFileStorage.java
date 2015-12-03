package ua.com.goit.gojava7.kickstarter.DAO.fileStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.model.Payment;

public class PaymentFileStorage extends AbstractPaymentStorage {
	private static int idGenerator;
	private File paymentFile;
	List<String> paymentLines;

	public PaymentFileStorage() {
		idGenerator = 0;
		paymentFile = new File("./resources/payment.csv");
		paymentLines = new ArrayList<>();
		ReadFile();
	}

	private void ReadFile() {
		try {
			paymentLines = FileUtils.readLines(paymentFile);
			if (paymentLines.size() > 0) {
				String[] id = paymentLines.get(paymentLines.size() - 1).split(";");
				idGenerator = Integer.parseInt(id[0]);
			}
		} catch (IOException e) {
			System.err.println("CSV file reading error");
		}
	}

	@Override
	public List<Payment> getAll() {
		ReadFile();
		List<Payment> allPayments = new ArrayList<>();
		if (paymentLines.size() > 0) {
			for (String paymentLine : paymentLines) {
				String[] splittedPaymentLine = paymentLine.split(";");
				Payment payment = new Payment();
				payment.setIdPayment(Integer.parseInt(splittedPaymentLine[0]));
				payment.setIdParentProject(Integer.parseInt(splittedPaymentLine[1]));
				payment.setCardOwner(splittedPaymentLine[2]);
				payment.setCardNumber(Long.parseLong(splittedPaymentLine[3]));
				payment.setRechargeAmount(Integer.parseInt(splittedPaymentLine[4]));
				allPayments.add(payment);
			}
		}
		return allPayments;
	}

	@Override
	public void add(Payment payment) {
		StringBuilder paymentLine = new StringBuilder(++idGenerator + ";");
		paymentLine.append(payment.getIdParentProject() + ";");
		paymentLine.append(payment.getCardOwner() + ";");
		paymentLine.append(payment.getCardNumber() + ";");
		paymentLine.append(payment.getRechargeAmount() + "\n");

		try {
			FileUtils.writeStringToFile(paymentFile, paymentLine.toString(), true);
		} catch (IOException e) {
			System.err.println("CSV file writting error");
		}
	}

	@Override
	public int getSummaryProjectCostsCollected(int idProject) {
		int costsCollected = 0;
		for (Payment payment : getAll()) {
			if (payment.getIdParentProject() == idProject) {
				costsCollected += payment.getRechargeAmount();
			}
		}
		return costsCollected;
	}

}
