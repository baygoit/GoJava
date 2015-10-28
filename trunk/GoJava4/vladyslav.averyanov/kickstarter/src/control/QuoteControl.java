package control;

import model.QuoteRepository;

public class QuoteControl {
	
	private QuoteRepository quoteRepository;
	
	public QuoteControl(){
		quoteRepository = new QuoteRepository();
	}
	
	public String getRandomQuote(){
		return quoteRepository.getRandomQuote();
	}
	
}
