package com.vladik.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.vladik.model.Payment;
import com.vladik.dao.AbstractPaymentDao;
import com.vladik.model.Project;

public class PaymentDaoFileImpl extends AbstractPaymentDao {
	private static final File STORAGE_FILE = new File("./src/main/resources/payments.csv");
	private static final int PROJECT_ID = 0;
	private static final int USER_NAME = 1;
	private static final int CREDIT_CARD_NUMBER = 2;
	private static final int DONATING_SUM = 3;

	@Override
	public void add(Payment element) {
		try (FileWriter fileWriter = new FileWriter(STORAGE_FILE, true)) {
			fileWriter.append(String.valueOf(element.getProjectID()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getUserName());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(String.valueOf(element.getCreditCardNumber()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(String.valueOf(element.getDonatingSum()));
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.flush();
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} 
	}
	
	@Override
	public List<Payment> getAll() {
		List<Payment> payments = new ArrayList<>();
		try (BufferedReader fileReader = new BufferedReader(new FileReader(STORAGE_FILE))) {
					
			// read header
			fileReader.readLine();
			
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {				
					Payment payment = new Payment();
					payment.setUserName(tokens[USER_NAME]);
					payment.setCreditCardNumber(Long.parseLong(tokens[CREDIT_CARD_NUMBER]));
					payment.setDonatingSum(Integer.parseInt(tokens[DONATING_SUM]));
					payment.setProjectID(Integer.parseInt(tokens[PROJECT_ID]));
					
					payments.add(payment);
				}
			}
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} 
		return payments;
	}

	@Override
	public int getSize() {
		return getAll().size();
	}
	
	@Override
	public int getSumProjectPayments(Project project) {
		List<Payment> projectPayments = new ArrayList<>();
		List<Payment> payments = getAll();
		
		for (Payment payment : payments) {
			if (payment.getProjectID() == project.getUniqueID()) {
				projectPayments.add(payment);
			}
		}
		
		if (projectPayments.isEmpty()) {
			return 0;
		} else {	
			int sumPayments = 0;		
			for (Payment payment : projectPayments) {
				sumPayments += payment.getDonatingSum();
			}	
			return sumPayments;
		}
	}
	
	@Override
	public void remove(Payment element) {
		// TODO Auto-generated method stub
	}
}
