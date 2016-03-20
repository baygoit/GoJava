package ua.nenya.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import ua.nenya.project.Quote;
import ua.nenya.dao.QuoteDao;

public class QuoteDaoFileImpl implements QuoteDao{
	
	private List<Quote> quotes = new ArrayList<>();
	private String fileName = "src/main/resources/quotes.json";

	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public QuoteDaoFileImpl() {
	}

	public List<Quote> getQuotes() {
		return quotes;
	}
	
	@Override
	public Quote getRandomQuote(Random random) {
		int quoteId = random.nextInt(quotes.size());
		return quotes.get(quoteId);
    }
	
	@Override
	public void initQuotes() {
		File file = new File(fileName);
		ObjectMapper mapper = new ObjectMapper();
		try {
			quotes = mapper.readValue(file, new TypeReference<List<Quote>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
