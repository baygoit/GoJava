package model;
import java.util.ArrayList;
import java.util.Arrays;


public class QuotesFromFile implements Quotes {
	private static final String QUOTES_PROPERTIES = "Quotes.properties";
	private String[] quote;
	private ArrayList<String[]> quoteBD;
	
	@Override
	public String getQuote(){
		ReaderDB reader = new ReaderDB();
		quoteBD = reader.read(QUOTES_PROPERTIES);
		ArrayList<String[]> linesAsArray = quoteBD;
		int countQuote = linesAsArray.size() - 1;
		quote = linesAsArray.get(random(countQuote));
		return Arrays.toString(quote);
	}

	@Override
	public int random(int countQuote) {
		return (int) (Math.random() * countQuote + 0.5);
	}
}
