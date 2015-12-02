package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class QuoteDaoFileImpl implements QuoteDao {
	private static final String CSV_SPLIT_BY = ";";
	private File quotesFile;
	private Random random;
	
	public QuoteDaoFileImpl(File quotesFile, Random random) {
		this.quotesFile = quotesFile;
		this.random = random;
	}

	@Override
	public Quote getRandomQuote() {
		List<Quote> quotes = new ArrayList<>();
		
		BufferedReader fileReader = null;
		try {
			InputStream quotesFileSteam = new FileInputStream(quotesFile);
			fileReader = new BufferedReader(new InputStreamReader(
					quotesFileSteam));

			String line = null;
			String quoteText = null;
			String author = null;
			while (null != (line = fileReader.readLine())) {
				String[] quote = line.split(CSV_SPLIT_BY);
				if (quote.length < 2) {
					throw new WrongFileFormatException(
							"Wrong quotes.csv format.");
				} else if (quote[0] == "") {
					throw new WrongFileFormatException(
							"Wrong quotes.csv format. Cannot find quote text");
				} else if (quote[1] == "") {
					throw new WrongFileFormatException(
							"Wrong quotes.csv format. Cannot find author");
				}
				quoteText = quote[0];
				author = quote[1];
				quotes.add(new Quote(quoteText, author));
			}
		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + quotesFile);
				}
			}
		}

		if (quotes.isEmpty()) {
			throw new WrongFileFormatException("There is not quotes in file");
		}

		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}
}
