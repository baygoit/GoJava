package control;

import model.QuoteRepository;

public class QuoteControl {
	
	QuoteRepository quoteRepository;
	
	QuoteControl(){
		quoteRepository = new QuoteRepository();
	}
	
	public String getRandomQuote(){
		return quoteRepository.getRandomQuote();
	}
	
}
