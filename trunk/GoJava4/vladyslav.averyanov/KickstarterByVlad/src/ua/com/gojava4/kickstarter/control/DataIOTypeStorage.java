package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class DataIOTypeStorage {
	
	private Reader reader;
	private Writer writer;
	private Dao genericDao;
	
	public DataIOTypeStorage(Reader reader,	Writer writer, Dao genericDao) {
		this.reader = reader;
		this.writer = writer;
		this.genericDao = genericDao;
	}

	public Reader getReader() {
		return reader;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public Dao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(Dao genericDao) {
		this.genericDao = genericDao;
	}
	
	

}
