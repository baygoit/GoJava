package ua.dborisenko.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ua.dborisenko.kickstarter.Quote;
import ua.dborisenko.kickstarter.dao.memory.QuoteDaoMemoryImpl;

public class QuoteDaoFileImpl extends QuoteDaoMemoryImpl {

	private String quotesFileName = "./src/main/resources/quotes.txt";

	public void setQuotesFileName(String quotesFileName) {
		this.quotesFileName = quotesFileName;
	}

	@Override
	public void fillAllQuotes() {
		try (BufferedReader is = new BufferedReader(new FileReader(quotesFileName))) {
			String text = is.readLine();
			String author = is.readLine();
			Quote quote = new Quote(text, author);
			getQuotes().add(quote);
		} catch (IOException e) {
			throw new IllegalStateException("Cannot read quotes from file");
		}
	}
}
