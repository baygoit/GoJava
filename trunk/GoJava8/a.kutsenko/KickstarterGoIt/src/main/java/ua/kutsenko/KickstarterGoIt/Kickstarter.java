package ua.kutsenko.KickstarterGoIt;

import java.util.Scanner;

import ua.kutsenko.KickstarterGoIt.dao.QuoteDao;
import ua.kutsenko.KickstarterGoIt.dao.QuoteDaoFile;
import ua.kutsenko.KickstarterGoIt.dao.QuoteDaoMemory;
import ua.kutsenko.KickstarterGoIt.dao.QuoteDaoSql;
import ua.kutsenko.KickstarterGoIt.domain.Quote;

public class Kickstarter implements Writer {

	QuoteDaoFile quoteDaoFile = new QuoteDaoFile();
	QuoteDaoSql quoteDaoSql = new QuoteDaoSql();
	QuoteDaoMemory quoteDaoMemory = new QuoteDaoMemory();
	Category selectedCategory = new Category();
	Project selectedProject = new Project();
	Quote quoteToOut = new Quote();
	private String env = System.getenv("Sql");

	public void run() {
		write(env);
		printQuote();
        selectCategory();
		while (true) {
			selectedCategory.showCategory();
			selectedCategory = selectedCategory.selectCategory();
			selectedCategory.showProjects(selectedCategory);
			selectedProject = selectedCategory.selectProject(selectedCategory);
			selectedCategory.actionProject(selectedProject, selectedCategory);

		}
	}

	private void printQuote() {
		if (env.equals("memory")) {
			quoteDaoMemory.fillQuotes();
			write(quoteDaoMemory.getQuote());
			;
		} else if (env.equals("file")) {
			quoteDaoFile.fillQuotes();
			write(quoteDaoFile.getQuote());
		} else if (env.equals("sql")) {
			quoteDaoSql.fillQuotes();
			write(quoteDaoSql.getQuote());
		}
	}
	
	

	@Override
	public void write(String string) {
		System.out.println(string);
	}

}
