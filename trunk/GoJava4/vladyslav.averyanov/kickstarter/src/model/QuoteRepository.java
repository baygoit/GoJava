package model;

import java.util.ArrayList;
import java.util.Random;

import model.Quote;

public class QuoteRepository {
	
	ArrayList <Quote> quotes;
	
	public QuoteRepository(){
		quotes = new ArrayList<>();
		
		quotes.add(new Quote("You know you're in love when you can't fall asleep because reality is finally better than your dreams",
				"Dr. Seuss"));
		quotes.add(new Quote("A friend is someone who knows all about you and still loves you",
				"Elbert Hubbard"));
		quotes.add(new Quote("It is better to be hated for what you are than to be loved for what you are not",
				"Andre Gide"));
		quotes.add(new Quote("It is not a lack of love, but a lack of friendship that makes unhappy marriages",
				"Friedrich Nietzsche"));
	}
	
	public ArrayList <Quote> getQuotes(){
		return quotes;
	}
	
	public String getRandomQuote(){
		return quotes.get(new Random().nextInt(quotes.size())).getQuoteWithAuthor();
	}

}
