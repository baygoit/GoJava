package belskii.artem.kickstarter.mvc.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belskii.artem.kickstarter.dao.quote.QuoteDao;


public class QuoteModel {
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	QuoteDao quoteDao = (QuoteDao) context.getBean("quoteDaoImplPsql"); 

	public String getRandomQuote() {
		return quoteDao.getRandomQuote();
	}

	public void addQuote(String quote) {
		quoteDao.addQuote(quote);
	}
}
