package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.templates.AbstractTemplateFiles;

public class QuotesStorage extends AbstractTemplateFiles<Quote> {

	private static final Random RANDOM = new Random();

	public QuotesStorage() {

		Quote quote1 = new Quote("B. Franklin", "Liberty will not descend to a people, a people must "
				+ "raise themselves to liberty; it is a blessing that must " + "be earned before it can be enjoyed.");

		Quote quote2 = new Quote("Ronald Reagan",
				"Government's first duty is to protect the people, not " + "run their lives.");

		Quote quote3 = new Quote("Ronald Reagan", "The most terrifying words in the English language are: "
				+ "I'm from the government and I'm here to help.");

		add(quote1);
		add(quote2);
		add(quote3);
	}

	public Quote getRandomQuote() {
		List<Quote> listQuotes = getAll();

//		int randomNumber = RANDOM.nextInt(listQuotes.size());

		return listQuotes.get(0);
	}

	@Override
	public void add(Quote element)   {
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(file, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      String [] record = "3,David,Feezor,USA,40".split(",");
        
      writer.writeNext(record);
				 
	}

	@Override
	public void remove(Quote element) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Quote> getAll() {
		List<Quote> quotes = new ArrayList<>();
//		Quote quote;
//
//		try (CSVReader reader = new CSVReader(new FileReader(file))) {
//			String[] nextLine;
//			while ((nextLine = reader.readNext()) != null) {
//				
//				String[] quoteTextAndAuthor = nextLine[0].split(";");
//
//				quote = new Quote(quoteTextAndAuthor[1], quoteTextAndAuthor[0]);
//				quotes.add(quote);
//			}
//
//		} catch (IOException e) {
//			System.out.println("Problems...");
//		}
//			CSVReader reader = null;
//			try {
//				reader = new CSVReader(new FileReader(file), ',', '\"', 1);
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//			ColumnPositionMappingStrategy<Quote> mappingStrategy = new ColumnPositionMappingStrategy<Quote>();
//			mappingStrategy.setType(Quote.class);
//			
//			// the fields to bind do in your JavaBean
//			String[] columns = new String[] {"quoteText","author"};
//			mappingStrategy.setColumnMapping(columns);
//			
//			CsvToBean<Quote> csv = new CsvToBean<Quote>();
//			List<Quote> quoteList = csv.parse(mappingStrategy, reader);
//			
//			for (int i = 0; i < quoteList.size(); i++) 
//			{
//			Quote quote = quoteList.get(i);
//			
//			// display CSV values
//			System.out.println("text : " + quote.getQuoteText());
//			System.out.println("author : " + quote.getAuthor());
//			System.out.println("------------------------------");
//			}
//			
//			
//			

		return quotes;
	}

}
