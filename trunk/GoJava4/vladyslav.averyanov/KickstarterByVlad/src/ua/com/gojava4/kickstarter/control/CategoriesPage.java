package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.model.repositories.Dao;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class CategoriesPage implements Page {
	
	Reader reader;
	Writer writer;
	Dao generalRepository;

	public CategoriesPage(Reader reader, Writer writer, Dao generalRepository) {
		this.reader = reader;
		this.writer = writer;
		this.generalRepository = generalRepository; 
	}

	@Override
	public void showPage() {
		Quote quote = generalRepository.getRandomQuote();
	}

}