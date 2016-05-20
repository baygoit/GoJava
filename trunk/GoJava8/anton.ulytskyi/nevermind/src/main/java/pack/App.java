package pack;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring-context.xml");
		QuoteService quoteService = (QuoteService) ctx.getBean("quoteService");
		
		Quote newQuote = new Quote();
		newQuote.setQuote("Wubbalubbadubdub!");
		//System.out.println(text.getQuote());
		quoteService.add(newQuote);
		
		
		List<Quote> list =quoteService.getAll();
		for(Quote quote:list){
		System.out.println(quote.getQuote());
		
		}
	
	}

}
