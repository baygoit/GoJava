package goit.nz.kickstartermvc.test;

import java.util.ArrayList;
import java.util.List;

import goit.nz.kickstartermvc.DataStorage;
import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.Quote;

public class MockStorage extends DataStorage {

	public MockStorage() {
		super();
	}
	
	public void init() {
		List<Quote> quotes = new ArrayList<>();
		List<Category> categories = new ArrayList<>();
		List<Project> projects = new ArrayList<>();
		Quote q1 = new Quote(
				"\"Start by doing what's necessary; then do what's possible; "
						+ "and suddenly you are doing the impossible.\"",
				"Francis of Assisi");
		Quote q2 = new Quote(
				"\"The best and most beautiful things in the world cannot be seen or even touched "
						+ "- they must be felt with the heart.\"",
				"Helen Keller");
		Quote q3 = new Quote(
				"\"I can't change the direction of the wind, "
						+ "but I can adjust my sails to always reach my destination.\"",
				"Jimmy Dean");
		Quote q4 = new Quote("Test Quote");
		quotes.add(q1);
		quotes.add(q2);
		quotes.add(q3);
		quotes.add(q4);
		registerQuotes(quotes);
		Category cat1 = new Category("Art");
		Category cat2 = new Category("Comics");
		Category cat3 = new Category("Crafts");
		Category cat4 = new Category("Games");
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);
		categories.add(cat4);
		registerCategories(categories);
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
		p1.setEvents("We have almost finished!\nWe are going to start!");
		p1.setLink("http://www.youtube.com/jrgri74ht3h97");
		p1.setFAQ("How can you imagine such idea?\nBecause of whisky, babe!");
		p2.setEvents("Blah-blah-blah-blah...");
		projects.add(p1);
		projects.add(p2);
		projects.add(p3);
		projects.add(p4);
		projects.add(p5);
		registerProjects(projects);
	}
	
	//for testing CategoryView
	public List<Project> getProjects(String catName) {
		List<Project> projects = new ArrayList<>();
		for (Project p : getProjects()) {
			if (p.getCategory().getName().equals(catName)) {
				projects.add(p);
			}
		}
		return projects;
	}
}
