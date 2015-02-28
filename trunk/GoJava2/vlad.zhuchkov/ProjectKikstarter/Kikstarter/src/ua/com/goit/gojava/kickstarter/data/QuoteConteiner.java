package ua.com.goit.gojava.kickstarter.data;

import java.util.ArrayList;
import java.util.Random;

public class QuoteConteiner {
	private ArrayList<String> quoteList = new ArrayList<>();

	public QuoteConteiner() {
		for (int i = 0; i < 10; i++)
			quoteList.add("quote" + i);
	}

	public String getQuote() {
		Random rand = new Random();
		int i = rand.nextInt(quoteList.size());
		return quoteList.get(i);
	}

}
