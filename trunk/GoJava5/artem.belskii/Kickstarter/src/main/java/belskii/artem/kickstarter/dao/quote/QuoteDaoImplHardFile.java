package belskii.artem.kickstarter.dao.quote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QuoteDaoImplHardFile implements QuoteDao {
	String FILE_PATH="src/main/resources/quotes.txt";

	@Override
	public String getRandomQuote() {
		Random random = new Random();
		int randomId = random.nextInt(this.getQuoteList().size());
		return this.getQuoteList().get(randomId);
	}

	@Override
	public void addQuote(String text) {
		 try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))
	        {
	           
	           	int index = this.getQuoteList().size();
	            writer.write(String.valueOf(index));
	            writer.append(";");
	            writer.append(text);
	            writer.append('\n');
	            writer.close();
	        }
	        catch(IOException ex){
	            
	            System.out.println(ex.getMessage());
	        } 
	}

	private ArrayList<String> getQuoteList() {
		ArrayList<String> quotesList = new ArrayList<String>();
	      try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH)))
	        {
	    	  	for(String line; (line = reader.readLine()) != null; ) {
	    	  		String splittedString [] = line.split(";");
	    	  		String quote=splittedString[1];
	    	  		quotesList.add(quote);
	    	  	}
	    	  	reader.close();
	        }
	        catch(IOException ex){
	            
	            System.out.println(ex.getMessage());
	        }   

		return quotesList;
	}

}
