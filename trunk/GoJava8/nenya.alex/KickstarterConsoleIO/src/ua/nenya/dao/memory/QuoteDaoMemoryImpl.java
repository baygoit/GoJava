package ua.nenya.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.nenya.dao.QuoteDao;
import ua.nenya.project.Quote;

public class QuoteDaoMemoryImpl implements QuoteDao{

	private List<Quote> quotes = new ArrayList<>();

	public QuoteDaoMemoryImpl() {
		initQuotes();
	}


	@Override
	public Quote getRandomQuote() {
        Random random = new Random();
		int quoteId = random.nextInt(quotes.size());
		return quotes.get(quoteId);
    }

    private void initQuotes() {
		quotes.add(new Quote("Healthy curiosity is a great key in innovation."));
		quotes.add(new Quote("Everyone here has the sense that right now is one of those moments when we are influencing the future."));
		quotes.add(new Quote("Great things in business are never done by one person. They're done by a team of people."));
    }

}
