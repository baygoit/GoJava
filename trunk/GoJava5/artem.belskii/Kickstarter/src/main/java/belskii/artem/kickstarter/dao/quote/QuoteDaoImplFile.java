package belskii.artem.kickstarter.dao.quote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QuoteDaoImplFile implements QuoteDao {
	String FILE_PATH="src/main/resources/dataInFiles/quotes.txt";

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

	@Override
	public void initDemoDB() {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false)))
        {   writer.write("");
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
	
	this.addQuote("Things work out best for those who make the best of how things work out.");
	this.addQuote("All our dreams can come true if we have the courage to pursue them.");
	this.addQuote("Success is walking from failure to failure with no loss of enthusiasm.");
	this.addQuote("Try not to become a person of success, but rather try to become a person of value.");
	this.addQuote("Don't be afraid to give up the good to go for the great.");
	}

}
