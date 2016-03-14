package ua.nenya.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.nenya.project.Category;
import ua.nenya.project.Quote;
import ua.nenya.dao.QuoteDao;

public class QuoteDaoFileImpl implements QuoteDao{
	
	private List<Quote> quotes = new ArrayList<>();

	
	public QuoteDaoFileImpl() {
		System.out.println("FromFile");
		initQuotes();
	}


	@Override
	public Quote getRandomQuote() {
        Random random = new Random();
		int quoteId = random.nextInt(quotes.size());
		return quotes.get(quoteId);
    }
	
	private void initQuotes() {
		File file = new File("src/main/resources/quotes.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			quotes = mapper.readValue(file, new TypeReference<List<Category>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
