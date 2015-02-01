package mainkick;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;


public class Quotes {
	private String[] quote;
	public static Map<Integer, String[]> quoteBD;
	{
	    try {
	    	ReaderBD reader = new ReaderBD();
	    	quoteBD = reader.read("Quotes.properties");
	    }
	    catch (IOException e) {
	       throw new RuntimeException(e);
	    }
	}
	
	public String[] getQuote() throws FileNotFoundException{
		Map<Integer, String[]> linesAsArray = quoteBD;
		quote = linesAsArray.get((int) (Math.random() * (linesAsArray.size() - 1) + 0.5));
		return quote;
	}
	
	public void setQuote(){
		//TODO write to base
	}
	
	public void addQuote(){
		//TODO write to base
	}
	
	public void deleteQuote(){
		//TODO write to base
	}
}
