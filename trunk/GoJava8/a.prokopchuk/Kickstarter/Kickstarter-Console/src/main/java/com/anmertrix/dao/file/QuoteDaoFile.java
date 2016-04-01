package com.anmertrix.dao.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

public class QuoteDaoFile implements QuoteDao {

	private String quotesFileName = "./src/main/resources/quotes.txt";
	protected List<Quote> quotes = new ArrayList<Quote>();
	
	@Override
	public void initData() {
		try (BufferedReader is = new BufferedReader(new FileReader(
				quotesFileName))) {
			String line;
			while ((line = is.readLine()) != null) {
				String[] quoteParts = line.split(";");
				Quote quote = new Quote();
				quote.setAuthor(quoteParts[0]);
				quote.setQuoteText(quoteParts[1]);
				quotes.add(quote);
			}
		} catch (Exception e) {
			quotes.clear();
			throw new IllegalStateException(
					"Couldn`t read quotes from the file");
		}
	}

	@Override
	public Quote getRandomQuote() {
		Random random = new Random();
		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}
}
