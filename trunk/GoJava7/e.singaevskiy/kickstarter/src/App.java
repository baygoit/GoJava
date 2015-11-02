import java.util.List;

import com.kickstarter.beans.Quote;
import com.kickstarter.dao.CommonDAO;
import com.kickstarter.dao.QuoteDAO;
import com.kickstarter.view.MainPage;

public class App {

	public static void main(String[] args) {
		start();
	}
	
	public static void start(){
		MainPage page = new MainPage();
		
		CommonDAO<Quote> quoteDAO = new QuoteDAO();
		List<Quote> quotes = quoteDAO.getAll();
		if (!quotes.isEmpty()) {
			page.updateQuote(quotes.get(0));
		}
		
	}

}
