package ua.com.gojava4.kickstarter.view.pages;

import ua.com.gojava4.kickstarter.control.ExitProgramException;
import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.entities.DataIOTypeStorage;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class ProjectsPage implements Page {
	
	DataIOTypeStorage dataIOTypeStorage;
	int categoryId;

	public ProjectsPage(DataIOTypeStorage dataIOTypeStorage, int categoryId) {
		this.dataIOTypeStorage = dataIOTypeStorage;
		this.categoryId = categoryId;
	}

	@Override
	public void showPage() {
		System.out.printf("ProjectsPage with categoryId = %d yet in construction", categoryId);
	}

	@Override
	public Page getNextPage() throws ExitProgramException {
		return new CategoriesPage(dataIOTypeStorage);
	}

}
