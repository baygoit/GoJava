package kickstarter.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import kickstarter.domain.Accounting;
import kickstarter.domain.Category;
import kickstarter.domain.Comments;
import kickstarter.domain.Project;
import kickstarter.domain.Quote;
import kickstarter.service.AccountingService;
import kickstarter.service.CategoryService;
import kickstarter.service.CommentsService;
import kickstarter.service.ProjectService;
import kickstarter.service.QuoteService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Manager {
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");

	public String getRandomQuote() {
		Random randomGenerator = new Random();

		QuoteService quoteService = (QuoteService) ctx.getBean("quoteService");
		List<Quote> quotes = quoteService.findAll();

		int index = randomGenerator.nextInt(quotes.size());
		Quote randomQuote = quotes.get(index);

		return randomQuote.getQuote();
	}

	public List<String> getAllCategories() {

		CategoryService categoryService = (CategoryService) ctx
				.getBean("categoryService");

		List<Category> categories = categoryService.findAll();
		List<String> categoriesList = new ArrayList<String>();

		for (Category category : categories) {
			String newCategory = category.getCategory();
			categoriesList.add(newCategory);
		}
		return categoriesList;
	}

	private List<Project> getAllProjects(String category) {

		ProjectService service = (ProjectService) ctx.getBean("projectService");
		List<Project> projects = service.findProjectsOfCategory(category);

		return projects;
	}

	public HashMap<Integer, String> getAllProjectsByCategory(String category) {
		List<Project> projects = getAllProjects(category);
		HashMap<Integer, String> projectsForWeb = new HashMap<Integer, String>();
		int id = 0;
		for (Project project : projects) {
			++id;
			String information = id + ". " + project.getName() + ". Budget: "
					+ getMoneyCollected(project.getId()) + "/"
					+ project.getNeedMoney() + " USD. Days after start: "
					+ getDaysFromStart(project.getStart()) + " days. ID - "
					+ project.getId() + ".";
			projectsForWeb.put(project.getId(), information);

		}
		return projectsForWeb;
	}

	private int getMoneyCollected(int id) {
		try {
			AccountingService service = (AccountingService) ctx
					.getBean("accountingService");
			Number account = service.getTheSumOfAccount(id);
			return account.intValue();
		} catch (NullPointerException zero) {
			return 0;
		}
	}

	private long getDaysFromStart(Date start) {
		Date now = new Date();
		long diff = now.getTime() - start.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public List<String> openProject(int id) {
		ProjectService service = (ProjectService) ctx.getBean("projectService");
		Project project = service.openProject(id);
		List<String> projectInformation = new ArrayList<>();
		projectInformation.add(project.getName());
		projectInformation.add(project.getUrl());
		projectInformation.add(project.getHistory());
		projectInformation.add("Budjet: " + getMoneyCollected(id) + "/"
				+ project.getNeedMoney() + " USD.");
		projectInformation.add("Ñontinues "
				+ getDaysFromStart(project.getStart()) + " days.");
		projectInformation.add("");
		projectInformation.add("Comments:");
		List<String> comments = getCommentsBy(id);
		projectInformation.addAll(comments);
		return projectInformation;
	}

	private List<String> getCommentsBy(int id) {

		CommentsService service = (CommentsService) ctx
				.getBean("commentsService");
		List<Comments> comments = service.findCommentsById(id);
		List<String> commentsForReading = new ArrayList<String>();
		for (Comments comment : comments) {
			commentsForReading.add(comment.getAuthor() + ": "
					+ comment.getText());
		}
		return commentsForReading;
	}

	public void sponsor(int id, int cash) {
		if (cash > 0 && cash < 100001) {
			AccountingService service = (AccountingService) ctx
					.getBean("accountingService");
			Accounting payment = new Accounting();
			payment.setDate(new Date());
			payment.setId(id);
			payment.setAmount(cash);
			service.persist(payment);
		}
	}

	public void addCommentTo(int id, String author, String text) {

		CommentsService commentsService = (CommentsService) ctx
				.getBean("commentsService");
		Comments comment = new Comments();
		comment.setId(id);
		comment.setAuthor(author);
		comment.setText(text);
		comment.setDate(new Date());
		commentsService.persist(comment);

	}
}
