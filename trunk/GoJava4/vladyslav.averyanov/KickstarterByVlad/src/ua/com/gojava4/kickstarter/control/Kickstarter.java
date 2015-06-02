package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.model.repositories.Repository;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class Kickstarter {
	
	Reader reader;
	Writer writer;
	Repository generalRepository;

	public Kickstarter(Reader reader, Writer writer, Repository generalRepository) {
		this.reader = reader;
		this.writer = writer;
		this.generalRepository = generalRepository; 
	}

	public void run() {
		
	}
}
