package goit.nz.kickstarter;

import goit.nz.kickstarter.dao.Category;
import goit.nz.kickstarter.dao.CategoryList;
import goit.nz.kickstarter.dao.Project;
import goit.nz.kickstarter.dao.ProjectList;
import goit.nz.kickstarter.dao.Quote;
import goit.nz.kickstarter.dao.QuoteList;

import java.util.ArrayList;

public class DataStorage {
	private QuoteList quotes;
	private CategoryList categories;
	private ArrayList<Project> projects;

	public DataStorage() {
		quotes = new QuoteList();
		categories = new CategoryList();
		projects = new ArrayList<Project>();
	}

	public void uploadData() {
		Quote q1 = new Quote(
				"\"Start by doing what's necessary; then do what's possible; "
						+ "and suddenly you are doing the impossible.\"",
				"Francis of Assisi", quotes);
		Quote q2 = new Quote(
				"\"The best and most beautiful things in the world cannot be seen or even touched "
						+ "- they must be felt with the heart.\"",
				"Helen Keller", quotes);
		Quote q3 = new Quote(
				"\"I can't change the direction of the wind, "
						+ "but I can adjust my sails to always reach my destination.\"",
				"Jimmy Dean", quotes);
		Quote q4 = new Quote("Test Quote", quotes);
		Category cat1 = new Category("Art", categories);
		Category cat2 = new Category("Comics", categories);
		Category cat3 = new Category("Crafts", categories);
		Category cat4 = new Category("Games", categories);
		Project p1 = new Project("name1", "desc1", 1000, 0, 10);
		Project p2 = new Project("name2", "desc2", 10000, 100, 90);
		Project p3 = new Project("name3", "desc3", 100, 90, 15);
		Project p4 = new Project("name4", "desc4", 100000, 50000, 100);
		p1.setCategory(cat2);
		p2.setCategory(cat4);
		p3.setCategory(cat3);
		p4.setCategory(cat4);
		Project p5 = new Project("Empty project");
		p5.setCategory(cat4);
		p1.setHistory("We have almost finished!\nWe are going to start!");
		p1.setLink("http://www.youtube.com/jrgri74ht3h97");
		p1.setQuestionsAnswers("How can you imagine such idea?\nBecause of whisky, babe!");
		p2.setHistory("Blah-blah-blah-blah...");
		projects.add(p1);
		projects.add(p2);
		projects.add(p3);
		projects.add(p4);
		projects.add(p5);
	}

	public QuoteList getQuotes() {
		return quotes;
	}

	public CategoryList getCategories() {
		return categories;
	}

	public ProjectList getProjects(int selected) {
		Category category = categories.getCategory(selected);
		ProjectList result = new ProjectList(category);
		for (Project p : projects) {
			if (p.getCategory().getName().equals(category.getName())) {
				result.add(p);
			}
		}
		return result;
	}
}
