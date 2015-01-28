import java.util.ArrayList;
import java.util.List;

public class Quote {
	private List<String> printQuote;
	public Quote() {
		printQuote = new ArrayList<String>();
		printQuote.add("\"Lost time is never found again.\"");
		printQuote.add("\"The future belongs to those, who believe of their dreams.\"");
		printQuote.add("\"If you never try you'll never know.\"");
		printQuote.add("\"The only way to do great work, is to love what you do.\"");
		printQuote.add("\"Every thing is easy, when you are crazy and nothing is easy when you are lazy.\"");
		printQuote.add("\"An investment in knowledge always pays the best interest.\"");
		printQuote.add("\"It does not matter how slowly you go so long as you do not stop.\"");
		printQuote.add("\"Money spent on the brain, is never spent in vain.\"");
   }

   public String getRundomQuote() {
	   int i = (int)(Math.random() * printQuote.size());
	   return printQuote.get(i);
	}
}