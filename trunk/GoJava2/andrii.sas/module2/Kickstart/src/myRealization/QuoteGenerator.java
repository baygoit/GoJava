package myRealization;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class QuoteGenerator implements Quote{
	private Random rand;
	private Output output;
	private List<String> quotes = new ArrayList<>(Arrays.asList(
			"If you don't know where you're going, you will probably end up somewhere else. (c) Laurence J. Peter",
			"Never confuse a single defeat with a final defeat. (c) F. Scott Fitzgerald",
			"You have to learn the rules of the game. And then you have to play better than anyone else. (c) Albert Einstein",
			"I want the world to be better because I was here. (c) Will Smith"));
	
	public QuoteGenerator(Output output, Random rand){
		this.rand = rand;
		this.output = output;
	}

	public String getQuote(int r){
		return quotes.get(r);
	}
	
	public void printQuote() {
		output.println(getQuote(rand.nextInt(quotes.size())));
	}
}
