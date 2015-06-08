package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.view.Page;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class CategoriesPage implements Page {
	
	Reader reader;
	Writer writer;
	Dao genericDao;

	public CategoriesPage(Reader reader, Writer writer, Dao generalRepository) {
		this.reader = reader;
		this.writer = writer;
		this.genericDao = generalRepository; 
	}

	@Override
	public void showPage() {
		Quote quote = genericDao.getRandomQuote();
	}

}