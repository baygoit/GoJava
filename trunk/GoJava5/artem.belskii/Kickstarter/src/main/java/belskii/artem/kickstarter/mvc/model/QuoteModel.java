package belskii.artem.kickstarter.mvc.model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import belskii.artem.kickstarter.dao.quote.QuoteDao;
import belskii.artem.kickstarter.dao.quote.QuoteDaoImplPsql;

public class QuoteModel {
	QuoteDao quoteDao = new QuoteDaoImplPsql("conf/database.conf");

	public String getRandomQuote() {
		return quoteDao.getRandomQuote();
	}

	public void addQuote(String quote) {
		quoteDao.addQuote(quote);
	}

	ApplicationContext contex = new ClassPathXmlApplicationContext("classpath*:test01.xml");
	String test = (String) contex.getBean("test");
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}


}
