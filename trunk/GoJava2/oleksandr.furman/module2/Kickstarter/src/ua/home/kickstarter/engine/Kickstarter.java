package ua.home.kickstarter.engine;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.content.Quote;
import ua.home.kickstarter.factory.DaoFactory;
import ua.home.kickstarter.model.CategoriesDao;
import ua.home.kickstarter.model.ProjectsDao;
import ua.home.kickstarter.model.QuotationsDao;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;

public class Kickstarter {
	private Display display;
	private ConsoleInput consoleInput;
	private ConsoleOutput consoleOutput;
	private Project project;
	private DaoFactory daoFactory;

	public Kickstarter(ConsoleOutput consoleOutput, ConsoleInput consoleInput, Display display, DaoFactory daoFactory) {
		this.consoleOutput = consoleOutput;
		this.consoleInput = consoleInput;
		this.display = display;
		this.daoFactory = daoFactory;
	}

	public void run() {
		display.displayQuote(getRandomQuote());
		menuLevel0();
	}

	public void menuLevel0() {
		display.displayCategories(getCategories());
		int input = consoleInput.nextIntIndex();
		if (input > 0 && input <= getCategoriesSize()) {
			display.displaySelectedCategoryName(getCategories().get(input - 1).getName());
			menuLevel1(input);
		} else if (input == 0) {
			consoleOutput.output("Спасибо за использование нашей программы!");
			return;
		} else {
			consoleOutput.output("Категория под номером " + input + " отстствует в системе, повторите ввод. \n");
			menuLevel0();
		}
	}

	public void menuLevel1(int categoryId) {
		display.displayProjects(getProjects(categoryId));
		menuLevel2(categoryId);
	}

	public void menuLevel2(int categoryId) {
		int input = -1;
		try {
			input = consoleInput.nextIntIndex();
			if (input > 0) {
				project = getSpecificProjectFromDB(categoryId, input);
				display.displaySpecificProject(project);
				menuLevel3(categoryId, input);
			} else if (input == 0) {
				menuLevel0();
			}
		} catch (IndexOutOfBoundsException e) {
			consoleOutput.output("Проект под номером " + input + " отстствует в системе, повторите ввод. \n");
			menuLevel2(categoryId);
		}
	}

	public void menuLevel3(int categoryId, int index) {
		int input = consoleInput.nextIntIndex();
		if (input == 0) {
			menuLevel1(categoryId);
		} else if (input == 1) {
			consoleOutput.output("Введите Ваше имя: ");
			consoleInput.nextString();
			consoleOutput.output("Введите номер карты: ");
			consoleInput.nextString();
			consoleOutput.output("Введите сумму платежа: ");
			int amount = consoleInput.nextIntIndex();
			project = getSpecificProjectFromDB(categoryId, index);
			project.addPayment(amount);
			updateProject(project.getId(), "pledged", project.getPledged());
			display.displaySpecificProject(project);
			menuLevel3(categoryId, index);
		} else {
			menuLevel3(categoryId, index);
		}
	}

	public Quote getRandomQuote() {
		Quote quote = null;
		try (Connection con = daoFactory.getConnection()) {
			QuotationsDao quotationsDao = daoFactory.getQuotationsDao(con);
			quote = quotationsDao.getSpecificQuoteFromDB(new Random());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quote;
	}

	public List<Category> getCategories() {
		List<Category> list = null;
		try (Connection con = daoFactory.getConnection()) {
			CategoriesDao categoriesDao = daoFactory.getCategoriesDao(con);
			list = categoriesDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getCategoriesSize() {
		int size = -1;
		try (Connection con = daoFactory.getConnection()) {
			CategoriesDao categoriesDao = daoFactory.getCategoriesDao(con);
			size = (int) categoriesDao.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

	public List<Project> getProjects(int categoryId) {
		List<Project> list = null;
		try (Connection con = daoFactory.getConnection()) {
			ProjectsDao projectsDao = daoFactory.getProjectsDao(con);
			list = projectsDao.getProjectsByCategoryId(categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Project getSpecificProjectFromDB(int categoryId, int projectIndex) {
		Project project = null;
		try (Connection con = daoFactory.getConnection()) {
			ProjectsDao projectsDao = daoFactory.getProjectsDao(con);
			project = projectsDao.getProjectsByIdAndCategoryId(categoryId, projectIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	public void updateProject(int projectId, String columnName, int amount) {
		try (Connection con = daoFactory.getConnection()) {
			ProjectsDao projectsDao = daoFactory.getProjectsDao(con);
			projectsDao.updateProject(projectId, columnName, amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
