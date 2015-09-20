package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class DataIOTypeStorage {
	
	private Reader reader;
	private Writer writer;
	private Dao dao;
	
	public DataIOTypeStorage(Reader reader,	Writer writer, Dao dao) {
		this.reader = reader;
		this.writer = writer;
		this.dao = dao;
	}

	public Reader getReader() {
		return reader;
	}

	public Writer getWriter() {
		return writer;
	}

	public Dao getDao() {
		return dao;
	}

}
