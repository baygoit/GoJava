package ua.nenya.dao.memory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import ua.nenya.project.Quote;
import ua.nenya.dao.QuoteDao;

public class QuoteDaoMemoryImpl implements QuoteDao{

	private List<Quote> quotes = new ArrayList<>();
	//private File file = new File("src/main/resources/quotes.json");
	private File file = new File("C:/workspace/GoJava8/KickstarterServlet/src/main/resources/quotes.json");
	public void setFile(File file) {
		this.file = file;
	}


	public List<Quote> getQuotes() {
		return quotes;
	}


	public QuoteDaoMemoryImpl() {
	}


	@Override
	public Quote getRandomQuote(Random random) {
		int quoteId = random.nextInt(quotes.size());
		return quotes.get(quoteId);
    }

	@Override
	public void initQuotes() {
		Quote quote1 = new Quote();
		quote1.setName("Healthy curiosity is a great key in innovation.");
		Quote quote2 = new Quote();
		quote2.setName("Everyone here has the sense that right now is one of those moments when we are influencing the future.");
		Quote quote3 = new Quote();
		quote3.setName("Great things in business are never done by one person. They're done by a team of people.");
		quotes.add(quote1);
		quotes.add(quote2);
		quotes.add(quote3);
		if(file.length() == 0 || !file.exists()){
			convertToJSON(quotes);
		}
    }
    
    private void convertToJSON(Object object) {

    	ObjectMapper mapper = new ObjectMapper();
		 try {
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			mapper.writeValue(file, object);
		} catch (IOException e) {
			e.printStackTrace();
		}
  }


}
