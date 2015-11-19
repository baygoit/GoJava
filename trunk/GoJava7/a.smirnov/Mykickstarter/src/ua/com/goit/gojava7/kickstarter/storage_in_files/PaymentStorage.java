package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.AbstractFilesStorage;
import ua.com.goit.gojava7.kickstarter.model.Payment;

public class PaymentStorage extends AbstractFilesStorage<Payment> {
	private final File file = new File("./sources/payments.csv");
	
	private static final int PRJECT_ID = 0;
	private static final int USER_NAME = 1;
	private static final int CREDIT_CARD_NUMBER = 2;
	private static final int DONATING_SUM = 3;

	@Override
	public List<Payment> getAll() {
		List<Payment> payments = new ArrayList<>();
		String line = "";
		
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader(file));
			
			fileReader.readLine();
			
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {
					
					Payment payment = new Payment(tokens[USER_NAME], 
							Long.parseLong(tokens[CREDIT_CARD_NUMBER]), Integer.parseInt(tokens[DONATING_SUM]));
					
					payment.setProjectID(Integer.parseInt(tokens[PRJECT_ID]));
					
					payments.add(payment);
				}
			}
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} finally {
	
			try {
				if (fileReader != null ) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}
		return payments;
	}
	
	@Override
	public void add(Payment element) {
		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(file, true);

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
		} finally {
	
			try {
				if (fileWriter != null ) {
					fileWriter.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}
	}
	
	@Override
	public void remove(Payment element) {
		// TODO Auto-generated method stub
		
	}
}
