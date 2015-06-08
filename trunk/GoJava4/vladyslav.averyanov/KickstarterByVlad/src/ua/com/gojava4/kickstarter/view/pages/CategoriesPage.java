package ua.com.gojava4.kickstarter.view.pages;

import java.util.List;

import ua.com.gojava4.kickstarter.control.ExitProgramException;
import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class CategoriesPage implements Page {

	Reader reader;
	Writer writer;
	Dao genericDao;
	List<Category> allCategories;

	public CategoriesPage(Reader reader, Writer writer, Dao genericDao) {
		this.reader = reader;
		this.writer = writer;
		this.genericDao = genericDao;
		this.allCategories = genericDao.getAllCategories();
	}

	@Override
	public void showPage() {
		showRandomQuote();
		showAllCategoriesList();
	}

	@Override
	public Page getNextPage() throws ExitProgramException {
		String userInput = reader.readUserInput();
		try {
			int categoryId = Integer.parseInt(userInput);
			for (Category category : allCategories) {
				if (category.getId() == categoryId) {
					return new ProjectsPage(reader, writer, genericDao,	categoryId);
				}
			}
		} catch (NumberFormatException e) {
			if (userInput.toLowerCase().equals("exit")
					|| userInput.toLowerCase().equals("quit")
					|| userInput.toLowerCase().equals("q")) {
				throw new ExitProgramException();
			}
		}
		showErrorDescription();
		return this;
	}

	private void showErrorDescription() {
		writer.print("Error input. Threre is no such category!\n"
				+ "To exit print q\n");
	}

	private void showAllCategoriesList() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n  Categories\n");
		for (Category category : allCategories) {
			sb.append("<" + category.getId() + "> " + category.getName() + "\n");
		}
		writer.println(sb.toString());
	}

	private void showRandomQuote() {
		writer.println();
		Quote quote = genericDao.getRandomQuote();
		writer.println(quote.getQuoteString());
	}

}