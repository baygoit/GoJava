package kickstarter.repository.fasade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.entities.Quote;


public class Repository {

	private List<Quote> quotes;
	private List<Category> categories;
	private List<Project> projects;
	private List<ProjectComments> allComments;
	public Repository(){
	
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
			project.investmentOptions=new String[]{"1$ - ","10$ -","40$ -"};
			project.amount=new double[] {1,10,40};
			projects.add(project);

			categoryID = 4;
			project = new Project("Paint the fence of the school", categoryID);
			project.description = "raising money for paint";
			project.investmentOptions=new String[]{"1$ - ","10$ -","40$ -"};
			project.amount=new double[] {1,10,40};
			project.ID = 8;
			projects.add(project);
	}
	public Category getCategory(int index) {
		return categories.get(index);
	}
	
	public int getCategoriesLength() {
		return categories.size();
	}

	public Quote getRandomQuote(){
		return quotes.get(new Random().nextInt(quotes.size()));
	}
	public ProjectComments getCommentsByProjectID(int projectID) {

		for (int index = 0; index < allComments.size(); index++) {
			if (allComments.get(index).projectID == projectID) {
				return allComments.get(index);
			}
		}
		return null;
	}
	public int getProjectsLength() {
		return projects.size();
	}

	public Project getProject(int index) {
		return projects.get(index);
	}

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
}
