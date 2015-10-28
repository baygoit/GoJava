package goit.nz.kickstartermvc.storage;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.FAQ;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.ProjectEvent;
import goit.nz.kickstartermvc.dao.Quote;
import goit.nz.kickstartermvc.dao.RewardOption;

import java.util.ArrayList;
import java.util.List;

public class MemoryStorage implements DataStorage{

	private List<Quote> quotes;
	private List<Category> categories;
	private List<Project> projects;

	public MemoryStorage() {
		quotes = new ArrayList<>();
		categories = new ArrayList<>();
		projects = new ArrayList<>();
	}

	private void registerQuotes(List<Quote> quotes) {
		this.quotes.addAll(quotes);
	}

	private void registerCategories(List<Category> categories) {
		this.categories.addAll(categories);
	}

	private void registerProjects(List<Project> projects) {
		this.projects.addAll(projects);
	}

	@Override
	public List<Quote> getQuotes() {
		return quotes;
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public List<Project> getProjects(String chosenCategoryName) {
		List<Project> result = new ArrayList<>();
		for (Project project : projects) {
			if (project.getCategory().getName().equals(chosenCategoryName)) {
				result.add(project);
			}
		}
		return result;
	}

	@Override
	public void addPledgedAmount(String categoryName, int projectIndex,
			int amount) {
		getProjects(categoryName).get(projectIndex - 1)
				.addPledgedAmount(amount);
	}

	@Override
	public void addQuestion(String categoryName, int projectIndex,
			String question) {
		FAQ faq = new FAQ(question);
		getProjects(categoryName).get(projectIndex - 1).addFAQ(faq);
	}
	
	@Override
	public void initStorage() {
		loadQuotes();
		loadCategories();
		loadProjects();
	}

	private void loadProjects() {
		List<Project> projects = new ArrayList<>();
		List<Category> categories = getCategories();
		Project p1 = new Project("name1", "desc1", 1000, 0, "31.08.2015");
		Project p2 = new Project("name2", "desc2", 10000, 100, "15.10.2015");
		Project p3 = new Project("name3", "desc3", 100, 90, "15.09.2015");
		Project p4 = new Project("name4", "desc4", 100000, 50000, "31.12.2015");
		p1.setCategory(categories.get(1));
		p2.setCategory(categories.get(3));
		p3.setCategory(categories.get(2));
		p4.setCategory(categories.get(3));
		Project p5 = new Project("Empty project");
		p5.setCategory(categories.get(3));
		ProjectEvent e1 = new ProjectEvent("We are going to start!", "01.01.2015");
		ProjectEvent e2 = new ProjectEvent("We have almost finished!", "31.05.2015");
		p1.addEvent(e1);
		p1.addEvent(e2);
		p1.setLink("http://www.youtube.com/jrgri74ht3h97");
		FAQ f1 = new FAQ("How can you imagine such idea?", "Because of whisky, babe!");
		p1.addFAQ(f1);
		RewardOption r1 = new RewardOption(10, "Cool T-shirt");
		RewardOption r2 = new RewardOption(50, "free beta testing");
		RewardOption r3 = new RewardOption(100, "lifelong title of founder");
		p1.addRewardOption(r1);
		p1.addRewardOption(r2);
		p1.addRewardOption(r3);
		ProjectEvent e3 = new ProjectEvent("Blah-blah-blah-blah...", "01.06.2015");
		p2.addEvent(e3);
		projects.add(p1);
		projects.add(p2);
		projects.add(p3);
		projects.add(p4);
		projects.add(p5);
		registerProjects(projects);
	}

	private void loadQuotes() {
		List<Quote> quotes = new ArrayList<>();
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
	}

	private void loadCategories() {
		List<Category> categories = new ArrayList<>();
		Category cat1 = new Category("Arts");
		Category cat2 = new Category("Comics");
		Category cat3 = new Category("Crafts");
		Category cat4 = new Category("Games");
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);
		categories.add(cat4);
		registerCategories(categories);
	}
}
