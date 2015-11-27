package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.AbstractQuoteDao;

public class QuoteDaoFileImpl extends AbstractQuoteDao {
	private static final File STORAGE_FILE = new File("./resources/quotes.csv");
	private static final Random RANDOM = new Random();
	private static final int AUTHOR = 0;
	private static final int QUOTE_TEXT = 1;

	@Override
	public void add(Quote element) {
		try (FileWriter fileWriter = new FileWriter(STORAGE_FILE, true)) {
			fileWriter.append(element.getQuoteText());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getAuthor());
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.flush();
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} 
	}

	public List<Quote> getAll() {
		List<Quote> quotes = new ArrayList<>();
		
		try (BufferedReader fileReader = new BufferedReader(new FileReader(STORAGE_FILE))) {
			
			// read header
			fileReader.readLine();
	
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {
					Quote quote = new Quote();
					quote.setQuoteText(tokens[QUOTE_TEXT]);
					quote.setAuthor(tokens[AUTHOR]);
					quotes.add(quote);
				}
			}
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		}
		return quotes;
	}

	@Override
	public int getSize() {
		return getAll().size();
	}
	
	@Override
	public Quote getRandomQuote() {
		List<Quote> quotes = getAll();
		int randomNumber = RANDOM.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}	
	
	@Override
	public void remove(Quote element) {
		// TODO Auto-generated method stub
	}
}
