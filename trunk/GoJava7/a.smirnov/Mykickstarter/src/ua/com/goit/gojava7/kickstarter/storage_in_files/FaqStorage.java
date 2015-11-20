package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.AbstractFilesStorage;
import ua.com.goit.gojava7.kickstarter.model.Faq;

public class FaqStorage extends AbstractFilesStorage<Faq>{
	
//	private static final File FILE_FOR_TEST = new File("./resources/FAQs.csv");
	private static final File REWARDS_FILE = new File("./FAQs.csv");
	
	private static final int PROJECT_ID = 0;
	private static final int QUESTION = 1;
	private static final int ANSWER = 1;
	
	@Override
	public void add(Faq element) {
		
		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(REWARDS_FILE, true);

			fileWriter.append(String.valueOf(element.getProjectID()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getQuestion());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getAnswer());
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
	public List<Faq> getAll() {
		List<Faq> faqs = new ArrayList<>();
		String line = "";
		
		
		BufferedReader fileReader = null;
		
		try {
			
			fileReader = new BufferedReader(new FileReader(REWARDS_FILE));
			
			fileReader.readLine();
			
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {
					
					Faq faq = new Faq(tokens[QUESTION]);
					
					faq.setAnswer(tokens[ANSWER]);
					faq.setProjectID(Integer.parseInt(tokens[PROJECT_ID]));
					
					faqs.add(faq);
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
		return faqs;
	}
	
	@Override
	public void remove(Faq element) {
		// TODO Auto-generated method stub
		
	}
}
