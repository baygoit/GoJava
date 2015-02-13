package ua.home.kickstarter.model;

import java.util.List;
import java.util.Random;

import ua.home.kickstarter.content.Quote;
import utils.KickstarterJsonReader;

public class QuotationsStorage {
	private List<Quote> quotationsList;

	public QuotationsStorage() {
		jsonQuotationsToList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void jsonQuotationsToList() {
		KickstarterJsonReader jsonReader = new KickstarterJsonReader();
		quotationsList = jsonReader.getList(Quote.class, "d:\\Quotations.json");
	}

	public Quote getRandomQuote() {
		int i = new Random().nextInt(quotationsList.size());
		return quotationsList.get(i);
	}
}
