package ua.com.goit.gojava7.kickstarter.dao.memory.reader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class Memory{

	public static final String	GAME_2		= "Game 2";
	private List<Quote>			quotes		= new ArrayList<>();
	private List<Category>		categories	= new ArrayList<>();
	private List<Project>		projects	= new ArrayList<>();
	private List<Question>		questions	= new ArrayList<>();

	public Memory() {
		initQuotes();

		initCategories();

		initProjects();

		initQuestions();

	}

	private void initQuotes() {
		Quote quote;
		quote = new Quote("I can't change the direction of the wind, but I can adjust my sails to always reach my destination.", "Jimmy Dean");
		quotes.add(quote);

		quote = new Quote("The best preparation for tomorrow is doing your best today.", "H. Jackson Brown, Jr.");
		quotes.add(quote);

		quote = new Quote("Nothing is impossible, the word itself says 'I'm possible'!", "Audrey Hepburn");
		quotes.add(quote);
	}

	private void initCategories() {
		Category category;
		category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Movies");
		categories.add(category);

		category = new Category("Books", 2);
		categories.add(category);

		category = new Category("Games", 3);
		categories.add(category);

		category = new Category("Technology", 4);
		categories.add(category);

	}

	private void initProjects() {
		final String demolink = "Demolink.com";
		final String categoryNameMovies = "Movies";
		final String categoryNameBooks = "Books";
		final String categoryNameGames = "Games";

		Project project;
		project = new Project("Movie 1", "Movie 1 Description", 1, LocalDateTime.now().plusDays(4));

		project.setCategoryName(categoryNameMovies);
		project.setDemoLink(demolink);
		projects.add(project);

		project = new Project("Movie 2", "Movie 2 Description", 1, LocalDateTime.now().plusDays(4));
		project.setCategoryName(categoryNameMovies);
		project.setDemoLink(demolink);
		projects.add(project);

		project = new Project("Book 1", "Book 1 Description", 2, LocalDateTime.now().plusDays(43));

		project.setCategoryName(categoryNameBooks);
		project.setDemoLink(demolink);
		projects.add(project);

		project = new Project("Book 2", "Book 2 Description", 2, LocalDateTime.now().plusDays(43));
		project.setCategoryName(categoryNameBooks);
		project.setDemoLink(demolink);
		projects.add(project);

		project = new Project("Game 1", "Game 1 Description", 3, LocalDateTime.now().plusDays(6));
		project.setCategoryName(categoryNameGames);
		project.setDemoLink(demolink);
		projects.add(project);

		project = new Project(GAME_2, "Game 2 Description", 3, LocalDateTime.now().plusDays(6));
		project.setCategoryName(categoryNameGames);
		project.setDemoLink(demolink);
		project.setProjectHistory("Some Project History");
		projects.add(project);

		projects.forEach(pr -> pr.setMoneyNeeded(50000));

	}

	private void initQuestions() {
		Question question = new Question();
		question.setQuestion("Why is that so?");
		question.setAnswer("Because");
		question.setProjectName(GAME_2);
		questions.add(question);

		question = new Question();
		question.setQuestion("When are you going to start");
		question.setAnswer("Soon, very soon");
		question.setProjectName(GAME_2);
		questions.add(question);

	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<Question> getQuestions() {
		return questions;
	}

}
