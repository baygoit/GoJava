package kickstarter.repository.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.entities.Quote;

public class Repository implements iRepository, Serializable {

	private static final long serialVersionUID = 1L;
	private List<Quote> quotes;
	private List<Category> categories;
	private List<Project> projects;
	private List<ProjectComments> allComments;

	public Repository() {

		quotes = new ArrayList<Quote>();
		Quote quote = new Quote();
		quote.setQuote("Explore projects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);

		categories = new ArrayList<Category>();
		Category category = new Category("Technology");
		category.ID = 5;
		categories.add(category);

		category = new Category("Social");
		category.ID = 4;
		categories.add(category);
		allComments = new ArrayList<ProjectComments>();

		ProjectComments comment = new ProjectComments(8);
		comment.addComment(1, "What color will paint?");
		comment.addComment(2, "Paint is Green");
		allComments.add(comment);

		comment = new ProjectComments(23);
		comment.addComment(3, "how much weight the bike?");
		comment.addComment(2, "The weight of bike is 15 kilo");
		allComments.add(comment);
		int categoryID = 5;
		projects = new ArrayList<Project>();
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
		projects.add(project);

		categoryID = 4;
		project = new Project("Paint the fence of the school", categoryID);
		project.description = "raising money for paint";
		project.investmentOptions = new String[] { "1$ - ", "10$ -", "40$ -" };
		project.amount = new double[] { 1, 10, 40 };
		project.ID = 8;
		projects.add(project);

		categoryID = 4;
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
		projects.add(project);

		categoryID = 5;
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
		projects.add(project);
		comment = new ProjectComments(20);
		comment.addComment(
				3,
				"One request: make sure your documentation and tutorials are crystal clear and checked by a native English speaker. (At one point they weren't) That's half of the product :)");
		comment.addComment(
				2,
				"Will your company be considering a camera module, fingerprint scanner or a capacitive lcd/led display with fingerprint scanner ability?");
		allComments.add(comment);
	}

	@Override
	public Category getCategory(int index) {
		return categories.get(index);
	}

	@Override
	public int getCategoriesLength() {
		return categories.size();
	}

	@Override
	public Quote getRandomQuote() {
		return quotes.get(new Random().nextInt(quotes.size()));
	}

	@Override
	public ProjectComments getCommentsByProjectID(int projectID) {

		for (int index = 0; index < allComments.size(); index++) {
			if (allComments.get(index).projectID == projectID) {
				return allComments.get(index);
			}
		}
		return null;
	}

	@Override
	public int getProjectsLength() {
		return projects.size();
	}

	@Override
	public Project getProject(int index) {
		return projects.get(index);
	}

	@Override
	public Project getProjectById(int ID) {
		int length = projects.size();

		for (int index = 0; index < length; index++) {
			Project currentProject = projects.get(index);
			if (currentProject.ID == ID) {
				return currentProject;
			}
		}
		return null;
	}

	@Override
	public List<Category> getListAllCategories() {
		return categories;
	}

	@Override
	public void addNewComment(int user, int projectID, String string) {
		ProjectComments comment = new ProjectComments(projectID);
		comment.addComment(user, string);
		allComments.add(comment);
	}
}
