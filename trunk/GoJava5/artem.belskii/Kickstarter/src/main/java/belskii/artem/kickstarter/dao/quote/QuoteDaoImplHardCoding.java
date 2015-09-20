package belskii.artem.kickstarter.dao.quote;

import java.util.HashMap;
import java.util.Random;

public class QuoteDaoImplHardCoding implements QuoteDao {
	HashMap<Long, String> quotes;
	public QuoteDaoImplHardCoding(){
		quotes=new HashMap<Long, String>();
		this.addQuote("Things work out best for those who make the best of how things work out.");
		this.addQuote("All our dreams can come true if we have the courage to pursue them.");
		this.addQuote("Success is walking from failure to failure with no loss of enthusiasm.");
		this.addQuote("Try not to become a person of success, but rather try to become a person of value.");
		this.addQuote("Don't be afraid to give up the good to go for the great.");		
	}
	
	public String getRandomQuote() {
		Random random = new Random();
		Long randomId = new Long(random.nextInt(this.quotes.size()));
		return this.quotes.get(randomId).toString();
	}

	public void addQuote(String text) {
		Long index = new Long(this.quotes.size());
		this.quotes.put(index, text);
	}

	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub
		
	}

}
