package com.ivanpozharskyi.kickstarter.main;

import java.io.IOException;
import java.util.ArrayList;

import com.ivanpozharskyi.kickstarter.datastorage.Answer;
import com.ivanpozharskyi.kickstarter.datastorage.Category;
import com.ivanpozharskyi.kickstarter.datastorage.CategoryStorage;
import com.ivanpozharskyi.kickstarter.datastorage.Project;
import com.ivanpozharskyi.kickstarter.datastorage.ProjectStorage;
import com.ivanpozharskyi.kickstarter.datastorage.Question;
import com.ivanpozharskyi.kickstarter.datastorage.QuestionStorage;
import com.ivanpozharskyi.kickstarter.datastorage.QuotesStorage;
import com.ivanpozharskyi.kickstarter.engine.ConsolePrinter;
import com.ivanpozharskyi.kickstarter.engine.ConsoleReader;
import com.ivanpozharskyi.kickstarter.engine.MenuController;
import com.ivanpozharskyi.kickstarter.engine.Printer;
import com.ivanpozharskyi.kickstarter.engine.Readable;

public class Kickstarter {
	private Printer printer;
	private Readable reader;
	private ConsolePrinter consolePrinter;
	private ConsoleReader consoleReader;
	private MenuController menuController;
	private QuotesStorage quotesStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	private QuestionStorage questionStorage;

	Kickstarter() {

		categoryStorage = new CategoryStorage();

		try {
			categoryStorage.addCategoriesFromFile("C:/workspace/Kickstarter/src/com/ivanpozharskyi/kickstarter/datastorage/Categories.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		projectStorage = new ProjectStorage(this);
		try {
			projectStorage.addProjectsFromFile("C:/workspace/Kickstarter/src/com/ivanpozharskyi/kickstarter/datastorage/Projects.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		questionStorage = new QuestionStorage(this);
		quotesStorage = new QuotesStorage();
		try {
			quotesStorage.addQuotesFromFile("C:/workspace/Kickstarter/src/com/ivanpozharskyi/kickstarter/datastorage/Quotes.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
//		ArrayList<Answer> answers = new ArrayList<Answer>();
//		answers.add(new Answer("waereaw1"));
//		answers.add(new Answer("qwewer2"));
//		questionStorage = new QuestionStorage(new Question("What?"), answers);
////		questionStorage.addQustion(new Question("When?"));
//		projectStorage.addQuestionAndAnswersInProject(project1, questionStorage);
		
		menuController = new MenuController(categoryStorage, projectStorage,quotesStorage,
				new ConsolePrinter(), new ConsoleReader());
		menuController.chooseMenu();

	}
	public CategoryStorage getCategoryStorage(){
		return categoryStorage;
	}

	public static void main(String[] args) {
		Kickstarter kick = new Kickstarter();

	}

}
