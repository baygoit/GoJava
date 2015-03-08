package com.kickstarter.model;
import java.util.Random;
public class QuotesStorage {
	
	  private Random random;
	  
	  public QuotesStorage(Random random) {
          this.random = random;
  }
		
	public String getRundomQuote() {
			String[] strings = new String[] {
					"Lost time is never found again.\"",
			    	"The future belongs to those, who believe of their dreams.\"",
			    	"If you never try you'll never know.\"",
			    	"The only way to do great work, is to love what you do.\"",
			    	"Every thing is easy, when you are crazy and nothing is easy when you are lazy.\"",
			    	"An investment in knowledge always pays the best interest.\"",
			    	"It does not matter how slowly you go so long as you do not stop.\"",
			    	"Money spent on the brain, is never spent in vain.\"",
					
    			};
			int index = random.nextInt(strings.length);  
			return strings[index];
	}
	
}