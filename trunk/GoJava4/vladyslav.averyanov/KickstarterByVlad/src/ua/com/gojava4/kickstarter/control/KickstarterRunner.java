package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.dao.GenericDaoImpl;
import ua.com.gojava4.kickstarter.model.repositories.SimpleRepositoryFactory;
import ua.com.gojava4.kickstarter.view.ConsoleReader;
import ua.com.gojava4.kickstarter.view.ConsoleWriter;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class KickstarterRunner {

	public static void main(String[] args) {
		Reader reader = new ConsoleReader();
		Writer writer = new ConsoleWriter();
		Dao genericDao = new GenericDaoImpl(new SimpleRepositoryFactory("quotes"),
				new SimpleRepositoryFactory("categories"),
				new SimpleRepositoryFactory("projects"));
		Kickstarter kickstarter = new Kickstarter(reader, writer, genericDao);
		kickstarter.run();
	}

}
