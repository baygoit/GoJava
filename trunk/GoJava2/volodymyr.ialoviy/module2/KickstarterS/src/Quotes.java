import java.io.FileNotFoundException;


public class Quotes {
	private String quote;
	
	public String getQuote() throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		
		String[] linesAsArray = reader.read("Quotes.properties", "");
		
		
		quote = linesAsArray[(int) (Math.random() * (linesAsArray.length - 1) + 1)];
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
