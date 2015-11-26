package ua.com.goit.gojava7.kikstarter.dao.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class QuoteDaoFile implements QuoteDao {

	private static final String SEMICOLON = ";";
	private File quoteFile;
	private FileWriter fileWriter;

	public QuoteDaoFile() {
		quoteFile = new File("./resources/quotes.csv");
	}

	@Override
	public void add(Quote quote) {
		String quoteString = (quote.getContent() + SEMICOLON + quote.getAuthor() + "\n");
		fileWriter = null;
		try {
			fileWriter = new FileWriter(quoteFile);
			fileWriter.append(quoteString);
			fileWriter.flush();
		} catch (IOException e) {
			System.out.println("CSV file writting error");
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader");
			}
		}
	}

	@Override
	public void remove(Quote quote) {
		System.out.println("Remove will be developed in furhter");
	}

	@Override
	public List<Quote> getAll() {
		List<Quote> quotes = new ArrayList<>();
		String line = "";
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(quoteFile));
//			fileReader.readLine();

			while ((line = fileReader.readLine()) != null) {
				String[] splitContentOfAuthor = line.split(SEMICOLON);
				if (splitContentOfAuthor.length > 0) {
					Quote quote = new Quote(splitContentOfAuthor[0], splitContentOfAuthor[1]);
					quotes.add(quote);
				}

			}
		} catch (IOException e) {
			System.out.println("Error in Read CSV file.");
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}

		return quotes;
	}

	@Override
	public Quote getRandomQuote() {
		List<Quote> quotes = getAll();
		return quotes.get(new Random().nextInt(quotes.size()));
	}

}
