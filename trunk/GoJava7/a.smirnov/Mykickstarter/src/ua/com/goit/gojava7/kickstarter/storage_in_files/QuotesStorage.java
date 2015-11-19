package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.AbstractFilesStorage;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuotesStorage extends AbstractFilesStorage<Quote> {
	private static final Random RANDOM = new Random();
	private final File file = new File("D:\\quotes.csv");
	
	private static final int AUTHOR = 0;
	private static final int QUOTE_TEXT = 1;

	public Quote getRandomQuote() {
		List<Quote> listQuotes = getAll();

		int randomNumber = RANDOM.nextInt(listQuotes.size());

		return listQuotes.get(randomNumber);
	}

	@Override
	public void add(Quote element) {
		
		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(file, true);

			fileWriter.append(element.getQuoteText());
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getAuthor());
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
	public List<Quote> getAll() {
		List<Quote> quotes = new ArrayList<>();
		String line = "";
		
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader(file));
			
			fileReader.readLine();
			
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {
					Quote quote = new Quote(tokens[QUOTE_TEXT], tokens[AUTHOR]);
					quotes.add(quote);
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

		return quotes;
	}
	
	@Override
	public void remove(Quote element) {
		// TODO Auto-generated method stub

	}
}
