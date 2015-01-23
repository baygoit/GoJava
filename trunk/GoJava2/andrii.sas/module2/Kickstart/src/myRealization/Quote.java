package myRealization;

import java.util.Random;

public class Quote {
	private Random rand;
	private String[] quotes = {
			"If you don't know where you're going, you will probably end up somewhere else. (c) Laurence J. Peter",
			"Never confuse a single defeat with a final defeat. (c) F. Scott Fitzgerald",
			"You have to learn the rules of the game. And then you have to play better than anyone else. (c) Albert Einstein",
			"I want the world to be better because I was here. (c) Will Smith" };

	public String getQuote(){
		rand = new Random();
		return quotes[rand.nextInt(quotes.length)];
	}
}
