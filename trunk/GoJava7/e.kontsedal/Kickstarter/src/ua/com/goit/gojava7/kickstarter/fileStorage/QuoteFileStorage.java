package ua.com.goit.gojava7.kickstarter.fileStorage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteFileStorage {
	private final Random random;
	private File quoteFile;

	public QuoteFileStorage() {
		random = new Random();
		quoteFile = new File("./resources/qoutes.csv");
	}

	public void addQuote(Quote quote) throws IOException {
		String quoteString = (quote.getText() + ";" + quote.getAuthor() + "/n");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(quoteFile);
			IOUtils.write(quoteString, fileWriter);
		} catch (Exception e) {
			System.err.println("CSV file writting error");
		} finally {
			IOUtils.closeQuietly(fileWriter);
		}
	}

	public List<Quote> getAllQuotes() {
		List<String> textsAndAuthors = null;
		List<Quote> allQuotes = new ArrayList<>();
		try {
			textsAndAuthors = FileUtils.readLines(quoteFile);
			for (String string : textsAndAuthors) {
				String[] splittedTextsAndAuthors = string.split(",");
				if (splittedTextsAndAuthors.length == 2) {
					allQuotes.add(new Quote(splittedTextsAndAuthors[0], splittedTextsAndAuthors[1]));
				} else {
					allQuotes.add(new Quote(splittedTextsAndAuthors[0], "unknown author"));
				}
			}
		} catch (IOException e) {
			System.out.println("CSV file reading error");
		}
		return allQuotes;
	}

	public Quote getRandomQuote() {
		int randomNumber = random.nextInt(getAllQuotes().size());
		return getAllQuotes().get(randomNumber);
	}

}
