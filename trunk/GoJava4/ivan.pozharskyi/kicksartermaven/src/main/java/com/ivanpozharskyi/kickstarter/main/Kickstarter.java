package com.ivanpozharskyi.kickstarter.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ivanpozharskyi.kickstarter.DAO.CategoriesDAO;
import com.ivanpozharskyi.kickstarter.DAO.ProjectsDao;
import com.ivanpozharskyi.kickstarter.DAO.QuotesDao;
import com.ivanpozharskyi.kickstarter.engine.ConsolePrinter;
import com.ivanpozharskyi.kickstarter.engine.ConsoleReader;
import com.ivanpozharskyi.kickstarter.engine.MenuController;
import com.ivanpozharskyi.kickstarter.engine.Printer;
import com.ivanpozharskyi.kickstarter.engine.Readable;
import com.ivanpozharskyi.kickstarter.entity.Answer;
import com.ivanpozharskyi.kickstarter.entity.Categories;
import com.ivanpozharskyi.kickstarter.entity.Category;
import com.ivanpozharskyi.kickstarter.entity.CategoriesImpl;
import com.ivanpozharskyi.kickstarter.entity.Project;
import com.ivanpozharskyi.kickstarter.entity.Projects;
import com.ivanpozharskyi.kickstarter.entity.ProjectsImpl;
import com.ivanpozharskyi.kickstarter.entity.Question;
import com.ivanpozharskyi.kickstarter.entity.QuestionStorage;
import com.ivanpozharskyi.kickstarter.entity.Quotes;
import com.ivanpozharskyi.kickstarter.entity.QuotesImpl;

public class Kickstarter {
	private Printer printer;
	private Readable reader;
	private ConsolePrinter consolePrinter;
	private ConsoleReader consoleReader;
	private MenuController menuController;
	private Quotes quotes;
	private Categories categories;
	private Projects projects;
	private QuestionStorage questionStorage;

	Kickstarter() throws SQLException {
		categories = new CategoriesDAO();
//
//		categories = new CategoriesImpl();
//
//		try {
//			categories.addCategoriesFromFile("C:/workspace/Kickstarter/src/com/ivanpozharskyi/kickstarter/datastorage/Categories.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		projects = new ProjectsDao();
//		projects = new ProjectsImpl(this);
//		try {
//			projects.addProjectsFromFile("C:/workspace/Kickstarter/src/com/ivanpozharskyi/kickstarter/datastorage/Projects.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		questionStorage = new QuestionStorage(this);
		quotes = new QuotesDao();
//		quotes = new QuotesImpl();
//		try {
//			quotes.addQuotesFromFile("C:/workspace/Kickstarter/src/com/ivanpozharskyi/kickstarter/datastorage/Quotes.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(); 
//		}
		
//		ArrayList<Answer> answers = new ArrayList<Answer>();
//		answers.add(new Answer("waereaw1"));
//		answers.add(new Answer("qwewer2"));
//		questionStorage = new QuestionStorage(new Question("What?"), answers);
////		questionStorage.addQustion(new Question("When?"));
//		projectStorage.addQuestionAndAnswersInProject(project1, questionStorage);
		
		menuController = new MenuController(categories, projects,quotes,
				new ConsolePrinter(), new ConsoleReader());
		menuController.chooseMenu();

	}
	public Categories getCategoies(){
		return categories;
	}

	public static void main(String[] args) throws SQLException {
		Kickstarter kick = new Kickstarter();

	}

}
