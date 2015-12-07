package ua.com.goit.gojava7.kickstarter.DAO.fileStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.*;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteFileStorage extends AbstractQuoteStorage {
	private static int idGenerator;
	private final Random random;
	private File quoteFile;
	List<String> quoteLines;

	public QuoteFileStorage() {
		idGenerator = 0;
		random = new Random();
		quoteFile = new File("./resources/qoutes.csv");
		ReadFile();
	}

	private void ReadFile() {
		try {
			quoteLines = FileUtils.readLines(quoteFile);
			if (quoteLines.size() > 0) {
				String[] id = quoteLines.get(quoteLines.size() - 1).split(";");
				idGenerator = Integer.parseInt(id[0]);
			}
		} catch (IOException e) {
			System.err.println("CSV file reading error");
		}
	}

	public Quote getRandomQuote() {
		int randomNumber = random.nextInt(getAll().size());
		return getAll().get(randomNumber);
	}

	public List<Quote> getAll() {
		ReadFile();
		List<Quote> allQuotes = new ArrayList<Quote>();
		if (quoteLines.size() > 0) {
			for (String string : quoteLines) {
				String[] splittedQuoteLine = string.split(";");
				Quote quote = new Quote();
				quote.setIdQuote(Integer.parseInt(splittedQuoteLine[0]));
				quote.setText(splittedQuoteLine[1]);
				quote.setAuthor(splittedQuoteLine[2]);
				allQuotes.add(quote);
			}
		}
		return allQuotes;
	}

	public void add(Quote quote) {
		StringBuilder quoteLine = new StringBuilder(++idGenerator + ";");
		quoteLine.append(quote.getText() + ";");
		quoteLine.append(quote.getAuthor() + "\n");
		try {
			FileUtils.writeStringToFile(quoteFile, quoteLine.toString(), true);
		} catch (IOException e) {
			System.err.println("CSV file writting error");
		}

	}

}
