package ua.kutsenko.KickstarterGoIt.dao;

import java.io.BufferedReader;
import java.io.FileReader;

import ua.kutsenko.KickstarterGoIt.domain.Quote;

public class QuoteDaoFile extends QuoteDao {

	private String quotesFileName = "./resources/quotes.txt";
	

	@Override
	public void fillQuotes() {
		   try (BufferedReader is = new BufferedReader(new FileReader(quotesFileName))) {
	            String line;
	            while ((line = is.readLine()) != null) {
	                String[] quoteParts = line.split("#");
	                Quote quote = new Quote( quoteParts[1], quoteParts[2]);
	                quotes.add(quote);
	            }
	        } catch (Exception e) {
	            quotes.clear();
	            throw new IllegalStateException("Couldn`t read quotes from the file");
	        }
	    }

	

    }


