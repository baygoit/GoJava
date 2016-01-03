package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class PaymentDaoFileImpl implements PaymentDao {
	private static final String CSV_SPLIT_BY = ";";
	private File paymentsFile;

	public PaymentDaoFileImpl(File paymentsFile) {
		this.paymentsFile = paymentsFile;
	}

	@Override
	public List<Payment> getPayments(int projectId) {
		List<Payment> payments = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream paymentsFileSteam = new FileInputStream(paymentsFile);
			fileReader = new BufferedReader(new InputStreamReader(
					paymentsFileSteam));

			String line = null;
			int id = 0;
			String name = null;
			String cardNumber = null;
			int pledge = 0;

			while (null != (line = fileReader.readLine())) {
				String[] questionLine = line.split(CSV_SPLIT_BY);
				if (questionLine.length < 5) {
					throw new WrongFileFormatException(
							"Wrong payments.csv format.");
				} else if (questionLine[0] == "") {
					throw new WrongFileFormatException(
							"Wrong payments.csv format. Cannot find id");
				} else if (questionLine[1] == "") {
					throw new WrongFileFormatException(
							"Wrong payments.csv format. Cannot find project id");
				} else if (questionLine[2] == "") {
					throw new WrongFileFormatException(
							"Wrong payments.csv format. Cannot find name in payment");
				} else if (questionLine[3] == "") {
					throw new WrongFileFormatException(
							"Wrong payments.csv format. Cannot find card number in payment");
				} else if (questionLine[4] == "") {
					throw new WrongFileFormatException(
							"Wrong payments.csv format. Cannot find pledge in payment");
				}

				if (projectId != 0
						&& projectId != Integer.parseInt(questionLine[1])) {
					continue;
				}
				id = Integer.parseInt(questionLine[0]);
				name = questionLine[2];
				cardNumber = questionLine[3];
				pledge = Integer.parseInt(questionLine[4]);

				Payment payment = new Payment();
				payment.setId(id);
				//payment.setProject(projectDao.getProject(projectId));
				payment.setName(name);
				payment.setCardNumber(cardNumber);
				payment.setPledge(pledge);

				payments.add(payment);
			}
		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error",
					e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + paymentsFile);
				}
			}
		}

		return payments;
	}

	@Override
	public void addPayment(Payment payment) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(paymentsFile, true);

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(generateIdOfNewElement()).append(";");
			stringBuilder.append(payment.getProject().getId()).append(";");
			stringBuilder.append(payment.getName()).append(";");
			stringBuilder.append(payment.getCardNumber()).append(";");
			stringBuilder.append(payment.getPledge());
			stringBuilder.append("\n");

			fileWriter.write(stringBuilder.toString().toString());

		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error",
					e);
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + paymentsFile);
				}
			}
		}

	}

	@Override
	public int getPledged(int projectId) {
		int pledged = 0;
		for (Payment payment : getPayments(projectId)) {
			if (payment.getProject().getId() == projectId) {
				pledged += payment.getPledge();
			}
		}
		return pledged;
	}

	private int generateIdOfNewElement() {
		int maxId = 0;
		for (Payment payment : getPayments(0)) {
			if (maxId < payment.getId()) {
				maxId = payment.getId();
			}
		}
		return maxId + 1;
	}

}
