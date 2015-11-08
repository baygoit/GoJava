package ua.com.gojava4.kickstarter.control;

import java.sql.SQLException;

import ua.com.gojava4.kickstarter.dao.ConnectionPoolImpl;
import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.dao.DaoImpl;
import ua.com.gojava4.kickstarter.view.ConsoleReader;
import ua.com.gojava4.kickstarter.view.ConsoleWriter;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class KickstarterRunner {

	public static void main(String[] args) throws SQLException {
		Reader reader = new ConsoleReader();
		Writer writer = new ConsoleWriter();
		Dao genericDao = new DaoImpl(new ConnectionPoolImpl());
		
		DataIOTypeStorage dataIOTypeStorage = new DataIOTypeStorage(reader, writer, genericDao);
		Kickstarter kickstarter = new Kickstarter(dataIOTypeStorage);
		kickstarter.run();
	}

}
