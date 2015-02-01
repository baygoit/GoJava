package mainkick;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Quotes {
	private String[] quote;
	public static ArrayList<String[]> quoteBD;
	{
	    try {
	    	ReaderBD reader = new ReaderBD();
	    	quoteBD = reader.read("Quotes.properties");
	    }
	    catch (IOException e) {
	       throw new RuntimeException(e);
	    }
	}
	
	public String getQuote() throws FileNotFoundException{
		ArrayList<String[]> linesAsArray = quoteBD;
		quote = linesAsArray.get((int) (Math.random() * (linesAsArray.size() - 1) + 0.5));
		return Arrays.toString(quote);
	}
}
