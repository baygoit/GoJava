package ua.com.sas.model;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class QuoteGenerator implements Quote{
	private Random rand;
	private List<String> quotes = new ArrayList<String>(Arrays.asList(
			"If you don't know where you're going, you will probably end up somewhere else. (c) Laurence J. Peter",
			"Never confuse a single defeat with a final defeat. (c) F. Scott Fitzgerald",
			"You have to learn the rules of the game. And then you have to play better than anyone else. (c) Albert Einstein",
			"I want the world to be better because I was here. (c) Will Smith"));
	
	public QuoteGenerator(Random rand){
		this.rand = rand;
	}

	public String getQuote(int r){
		return quotes.get(r);
	}
	
	private int generateNumber(){
		return rand.nextInt(quotes.size());
	}
	
	public String generateQuote(){
		return getQuote(generateNumber()); 
	}
}
