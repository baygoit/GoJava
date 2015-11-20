package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.PaymentReader;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.exception.PaymentReadException;

public class FilePaymentReader implements PaymentReader {	
	private static final String CSV_SPLIT_BY = ";";	
	private File paymentsFile;

	public FilePaymentReader(File paymentsFile) {
		this.paymentsFile = paymentsFile;
	}

	@Override
	public List<Payment> readPayments() {
		List<Payment> payments = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream paymentsFileSteam = new FileInputStream(paymentsFile);
			fileReader = new BufferedReader(new InputStreamReader(
					paymentsFileSteam));

			String line = null;
			int id = 0;
			int projectId = 0;
			String name = null;
			String cardNumber = null;
			int pledge = 0;
			
			while (null != (line = fileReader.readLine())) {
				String[] questionLine = line.split(CSV_SPLIT_BY);
				if (questionLine.length < 5) {
					throw new PaymentReadException("Wrong payments.csv format.");
				} else if (questionLine[0] == "") {
					throw new PaymentReadException(
							"Wrong payments.csv format. Cannot find id");
				} else if (questionLine[1] == "") {
					throw new PaymentReadException(
							"Wrong payments.csv format. Cannot find project id");
				} else if (questionLine[2] == "") {
					throw new PaymentReadException(
							"Wrong payments.csv format. Cannot find name in payment");
				} else if (questionLine[3] == "") {
					throw new PaymentReadException(
							"Wrong payments.csv format. Cannot find card number in payment");
				} else if (questionLine[4] == "") {
					throw new PaymentReadException(
							"Wrong payments.csv format. Cannot find pledge in payment");
				}
				
				id = Integer.parseInt(questionLine[0]);
				projectId = Integer.parseInt(questionLine[1]);
				name = questionLine[2];
				cardNumber = questionLine[3];
				pledge = Integer.parseInt(questionLine[4]);
				
				Payment payment = new Payment(id);
				payment.setProjectId(projectId);
				payment.setName(name);
				payment.setCardNumber(cardNumber);
				payment.setPledge(pledge);
				
				payments.add(payment);
			}
		} catch (IOException e) {
			throw new PaymentReadException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + paymentsFile);
				}
			}
		}

		if (payments.isEmpty()) {
			throw new PaymentReadException("There is not payments in file");
		}

		return payments;
	}

}
