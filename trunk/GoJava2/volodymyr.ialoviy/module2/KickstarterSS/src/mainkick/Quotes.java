package mainkick;
import java.io.FileNotFoundException;
import java.util.Map;


public class Quotes {
	private String quote;
	
	public String getQuote() throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		Map<Integer, String> linesAsArray = reader.read("Quotes.properties", "");
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
