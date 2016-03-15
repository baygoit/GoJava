package com.anmertrix;

import java.io.IOException;
import java.util.List;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.file.CategoryDaoFile;
import com.anmertrix.dao.file.QuoteDaoFile;
import com.anmertrix.dao.memory.CategoryDaoMemory;
import com.anmertrix.dao.memory.ProjectDaoMemory;
import com.anmertrix.dao.memory.QuoteDaoMemory;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;

public class Kickstarter {

	private IO io;

	public Kickstarter(IO io) {
		this.io = io;
	}

	public static void main(String[] args) throws IOException {
		new Kickstarter(new ConsoleIO()).run();

	}

	private void run() throws IOException {
		String read_env = System.getenv("READ_OBJECT_KICKSTARTER");
		QuoteDao quoteDao;
		System.out.println(read_env);
		CategoryDao categoryDao;
		if (read_env.equals("file")) {
			quoteDao = new QuoteDaoFile();
			categoryDao = new CategoryDaoFile();
		} else if (read_env.equals("memory")) {
			quoteDao = new QuoteDaoMemory();
			categoryDao = new CategoryDaoMemory();
		} else if (read_env.equals("sql")) {
			quoteDao = new QuoteDaoSql();
			categoryDao = new CategoryDaoSql();
		} else {
			System.out.println("Add environment variable READ_OBJECT_KICKSTARTER.");
			return;
		}
		quoteDao.fillQuotes();
		categoryDao.fillCategory();
		
		ProjectDao projectSource = new ProjectDaoMemory(categoryDao);
		if (read_env.equals("memory")) {
			projectSource.fillCategory();
		}

		io.println(quoteDao.getRandomQuote());

		while (true) {
			io.println(categoryDao.getCategoriesMenu());

			int numberCategory = 0;
			numberCategory = getParseInputNumber(io.readConsole());
			if (numberCategory == -1) {
				io.print("Bye..!");
				break;
			} else {
				try {
					io.print("You select: ");
					io.println(categoryDao
							.getNameSelectedCategory(numberCategory));
				} catch (Exception e) {
					System.out.println("There is no such category!");
					continue;
				}
			}

			while (true) {
				io.println(projectSource.getProjectList(numberCategory));
				io.println("______________________________");
				int numberProject = 0;
				numberProject = getParseInputNumber(io.readConsole());
				if (numberProject == -1) {
					break;
				} else {
					io.print("You select: ");
					io.println(projectSource.getInfoSelectedProject(
							numberCategory, numberProject));
					io.println("______________________________");
					io.print(projectSource.getProjectMenu());
					int numberMenuItem = 0;
					numberMenuItem = getParseInputNumber(io.readConsole());

					Category category = categoryDao
							.getCategory(numberCategory);
					List<Project> projects = category.getProjects();
					Project project = projects.get(numberProject);
					if (numberMenuItem == -1) {
						break;
					} else if (numberMenuItem == 0) {
						io.print("Enter your guestion: ");
						String guestion = io.readConsole();
						project.setQuestion(guestion);
						io.println("______________________________");
						continue;

					} else if (numberMenuItem == 1) {
						io.println("Enter your amount of money to invest:  ");
						int amountNumber = 0;
						amountNumber = getParseInputNumber(io.readConsole());
						if (amountNumber == -1) {
							break;
						} 
						project.setGatheredBudget(amountNumber);
						io.println("______________________________");
						continue;

					} else if (numberMenuItem == 2) {
						io.println("Select one or enter 0 - to exit:  ");
						io.println("1 - 1$ - BIG THANK!");
						io.println("2 - 20$ - Solo supporter!");
						io.println("3 - 40$ - Calm supporter!");
						int numberCount = 0;
						numberCount = getParseInputNumber(io.readConsole());
						if (numberCount == -1) {
							break;
						} else if (numberCount == 0) {
							project.setGatheredBudget(1);
						} else if (numberCount == 1) {
							project.setGatheredBudget(10);
						} else if (numberCount == 2) {
							project.setGatheredBudget(40);
						}
						io.println("______________________________");
						continue;

					} else if (numberMenuItem == 2) {
						continue;
					}

				}

				io.println("Enter 0 to see all projects.");
				int number = getParseInputNumber(io.readConsole());
				if (number == 0) {
					continue;
				}
			}
		}
	}

	public int getParseInputNumber(String text) {
		int result = 0;

		try {
			result = (Integer.parseInt(text));
		} catch (NumberFormatException e) {
			io.println("You can enter only numbers. \"" + text
					+ "\" is not a number.\n ");
		}

		return result - 1;
	}
}
