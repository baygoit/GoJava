package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractFaqDao;

public class FaqDaoFileImpl extends AbstractFaqDao {
	private static final File FILE_STORAGE = new File("./resources/FAQs.csv");
	private static final int PROJECT_ID = 0;
	private static final int QUESTION = 1;
	private static final int ANSWER = 2;
	
	@Override
	public void add(Faq element) {
		try (FileWriter fileWriter = new FileWriter(FILE_STORAGE, true)) {
			fileWriter.append(String.valueOf(element.getProjectID()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getQuestion());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getAnswer());
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.flush();
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		}
	}

	@Override
	public List<Faq> getAll() {
		List<Faq> faqs = new ArrayList<>();		
		try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_STORAGE))) {
				
			// read header
			fileReader.readLine();
		
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {
					Faq faq = new Faq();
					faq.setQuestion(tokens[QUESTION]);
					faq.setAnswer(tokens[ANSWER]);
					faq.setProjectID(Integer.parseInt(tokens[PROJECT_ID]));
					faqs.add(faq);
				}
			}
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} 
		return faqs;
	}

	@Override
	public int getSize() {
		return getAll().size();
	}
	
	@Override
	public String getProjectFaqs(Project project) {
		List<Faq> allFaqs = getAll();
		StringBuilder resultFaqs = new StringBuilder();
		
		for (int index = 0; index < allFaqs.size(); index ++) {
			if (allFaqs.get(index).getProjectID() == project.getUniqueID()) {
				resultFaqs.append("\n  question : " + allFaqs.get(index).getQuestion() + "\n");
				
				if (allFaqs.get(index).getAnswer() == null || allFaqs.get(index).getAnswer().isEmpty()) {
					resultFaqs.append("  answer: There is no answer yet \n");
				} else {
					resultFaqs.append("  answer : " + allFaqs.get(index).getAnswer() + "\n");
				}	
			}
		}
		
		if (resultFaqs.length() == 0) {
			return "no questions";
		} else {
			return resultFaqs.toString();
		}
	}	
	
	@Override
	public void remove(Faq element) {
		// TODO Auto-generated method stub
	}
}
