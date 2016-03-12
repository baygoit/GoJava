package ua.nenya.dao.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.nenya.dao.QuoteDao;
import ua.nenya.project.Quote;

public class QuoteDaoFileImpl implements QuoteDao{
	
	private String quotesFileName = "src/resources/quotes.txt";

	public void setQuotesFileName(String quotesFileName) {
		this.quotesFileName = quotesFileName;
	}
	
	private List<Quote> quotes = new ArrayList<>();

	
	public QuoteDaoFileImpl() {
		initQuotes();
	}


	@Override
	public Quote getRandomQuote() {
        Random random = new Random();
		int quoteId = random.nextInt(quotes.size());
		return quotes.get(quoteId);
    }
	
	private void initQuotes() {
		try (BufferedReader reader = new BufferedReader(new FileReader(quotesFileName))) {
			while (reader.ready()) {
				String quote = reader.readLine();
				quotes.add(new Quote(quote));
			}
		} catch (IOException e) {
			throw new IllegalStateException("Cannot read quotes from file");
		}
    }

}
