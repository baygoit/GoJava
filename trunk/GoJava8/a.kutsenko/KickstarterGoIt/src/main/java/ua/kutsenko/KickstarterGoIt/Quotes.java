package ua.kutsenko.KickstarterGoIt;

import java.util.Random;

public class Quotes {
	public void printQuote() {
		System.out.println(allQuotes[index]);
	}

	private String[] allQuotes = { "Клевета как уголь: не обожжет, так замарает.", 
			"Помирать собрался, а жито сей.",
			"Утро вечера мудренее.", "Плох тот солдат, который не думает быть генералом.",
			"У Фили пили, да Филю ж и били." };

	private int index = new Random().nextInt(allQuotes.length);

}
