package ua.com.gojava4.kickstarter.view.pages;

import ua.com.gojava4.kickstarter.control.ExitProgramException;
import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class ProjectsPage implements Page {
	
	Reader reader;
	Writer writer;
	Dao genericDao;
	int categoryId;

	public ProjectsPage(Reader reader, Writer writer, Dao genericDao, int categoryId) {
		this.reader = reader;
		this.writer = writer;
		this.genericDao = genericDao;
		this.categoryId = categoryId;
	}

	@Override
	public void showPage() {
		System.out.printf("ProjectsPage with categoryId = %d yet in construction", categoryId);
	}

	@Override
	public Page getNextPage() throws ExitProgramException {
		return new CategoriesPage(reader, writer, genericDao);
	}

}
