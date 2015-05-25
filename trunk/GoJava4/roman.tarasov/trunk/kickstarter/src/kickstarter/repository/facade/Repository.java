package kickstarter.repository.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.entities.Quote;

public class Repository {

	private List<Quote> quotes;
	private HashMap<Integer, Category> categoriesByTheirIDs;
	private HashMap<Integer, Project> oneProjectByProjectID;
	private HashMap<Integer, HashMap<Integer, Project>> projectsByCategoryID;
	private HashMap<Integer, ProjectComments> commentsByProjectID;

	public Repository() {
		projectsByCategoryID = new HashMap<Integer, HashMap<Integer, Project>>();
		categoriesByTheirIDs = new HashMap<Integer, Category>();
		commentsByProjectID = new HashMap<Integer, ProjectComments>();
		quotes = new ArrayList<Quote>();
		Quote quote = new Quote();
		quote.setQuote("Explore projects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);

		Category category = new Category("Technology");
		category.ID = 5;
		categoriesByTheirIDs.put(category.ID, category);

		category = new Category("Social");
		category.ID = 4;
		categoriesByTheirIDs.put(category.ID, category);

		int projectID = 8;
		ProjectComments comment = new ProjectComments(projectID);
		comment.addComment(1, "What color will paint?");
		comment.addComment(2, "Paint is Green");
		commentsByProjectID.put(projectID, comment);

		projectID = 8;
		comment = new ProjectComments(projectID);
		comment.addComment(3, "how much weight the bike?");
		comment.addComment(2, "The weight of bike is 15 kilo");
		commentsByProjectID.put(projectID, comment);

		// =================================================================================
		int categoryID = 5;
		oneProjectByProjectID = new HashMap<Integer, Project>();
		Project project = new Project("Create electrobike", categoryID);
		project.description = "high efficiency";
		project.shortDescription = "short description";
		project.history = "history of bike creation";
		project.linkToVideo = "www.link.to.demo.video";
		project.pledged = 25;
		project.goal = 2000;
		project.ID = 23;
		project.investmentOptions = new String[] { "1$ - ", "10$ -", "40$ -" };
		project.amount = new double[] { 1, 10, 40 };
		oneProjectByProjectID.put((Integer) project.ID, project);

		project = new Project("Microduino mCookie", categoryID);
		project.description = "Small, stackable, Arduino-compatible electronics for makers, designers, engineers, students and curious tinkerers of all ages.";
		project.shortDescription = "The smallest electronic modules on LEGO";
		project.history = "history of Microduino mCookie";
		project.linkToVideo = "https://www.microduino.cc/module/view?id=53da0abdc69eee000055f55d";
		project.pledged = 205;
		project.goal = 20000;
		project.ID = 20;
		project.investmentOptions = new String[] { "10$ - ", "20$ -", "100$ -" };
		project.amount = new double[] { 10, 20, 100 };
		oneProjectByProjectID.put((Integer) project.ID, project);
		projectsByCategoryID.put(categoryID, oneProjectByProjectID);
		
		comment = new ProjectComments(project.ID);
		comment.addComment(
				3,
				"One request: make sure your documentation and tutorials are crystal clear and checked by a native English speaker. (At one point they weren't) That's half of the product :)");
		comment.addComment(
				2,
				"Will your company be considering a camera module, fingerprint scanner or a capacitive lcd/led display with fingerprint scanner ability?");
		commentsByProjectID.put(project.ID, comment);

		// =================================================================================
		categoryID = 4;
		oneProjectByProjectID = new HashMap<Integer, Project>();

		project = new Project("Paint the fence of the school", categoryID);
		project.description = "raising money for paint";
		project.investmentOptions = new String[] { "1$ - ", "10$ -", "40$ -" };
		project.amount = new double[] { 1, 10, 40 };
		project.ID = 8;
		oneProjectByProjectID.put((Integer) project.ID, project);

		project = new Project("Help Build ACRE's New Home in Chicago",
				categoryID);
		project.description = "The renovation of our new space and expansion of our Chicago programming!";
		project.shortDescription = "Help ACRE achieve our most ambitious project to date";
		project.investmentOptions = new String[] { "100$ - ", "150$ -",
				"400$ -" };
		project.amount = new double[] { 100, 150, 400 };
		project.pledged = 5000;
		project.goal = 10000;
		project.ID = 1;
		oneProjectByProjectID.put((Integer) project.ID, project);
		projectsByCategoryID.put(categoryID, oneProjectByProjectID);
		// =================================================================================
	}

	public Quote getRandomQuote() {
		return quotes.get(new Random().nextInt(quotes.size()));
	}

	public ProjectComments getCommentsByProjectID(int projectID) {
		return commentsByProjectID.get(projectID);
	}

	public List<Project> getListOfProjectsByCategoryID(Integer categoryID) {
		ArrayList<Project> result = new ArrayList<Project>();
		HashMap<Integer, Project> projects = projectsByCategoryID
				.get(categoryID);
		for (Entry<Integer, Project> entry : projects.entrySet()) {
			Project value = entry.getValue();
			result.add(value);
		}
		return result;
	}

	public List<Category> getListAllCategories() {
		ArrayList<Category> result = new ArrayList<Category>();
		for (Entry<Integer, Category> entry : categoriesByTheirIDs.entrySet()) {

			Category value = entry.getValue();
			result.add(value);
		}
		return result;
	}

	public Project getProjectByCategoryIDandProjectID(int selectedCategory,
			int intSelectedProject) {
		HashMap<Integer, Project> projects = projectsByCategoryID
				.get((Integer) selectedCategory);
		return projects.get((Integer) intSelectedProject);
	}

	public void addNewComment(int user, int projectID, String string) {
		ProjectComments comment = new ProjectComments(projectID);
		comment.addComment(user, string);
		commentsByProjectID.put(projectID, comment);
	}
}
