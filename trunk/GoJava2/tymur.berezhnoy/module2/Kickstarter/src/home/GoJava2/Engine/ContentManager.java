package home.GoJava2.Engine;
import home.GoJava2.Content.Category;
import home.GoJava2.Content.Project;
import home.GoJava2.Content.Quote;
import home.GoJava2.DataBase.CategoryStorage;
import home.GoJava2.DataBase.ProjectStorage;
import home.GoJava2.DataBase.QuoteStorage;

import java.util.List;

public class ContentManager implements QuoteManagement, CategoryManagement {

	private CategoryStorage categoryStorage;
	private QuoteStorage qouteStorage;
	private ProjectStorage projectStorage;
	
	public ContentManager(QuoteStorage qouteStorage, CategoryStorage categoryStorage, ProjectStorage projectStorage) {
		this.categoryStorage = categoryStorage;
		this.qouteStorage = qouteStorage;
		this.projectStorage = projectStorage;
	}
	
	@Override
	public void createQuote(String content, String author) {
		Quote quote = new Quote(content, author);
		qouteStorage.addQuoteToStorage(quote);
	}
	
	@Override
	public Quote getQuote() {
		return qouteStorage.getRandomQuote();
	}
	
	@Override
	public QuoteStorage getQuoteStorage() {
		return qouteStorage;
	}
	
	
	@Override
	public List<Category> getCategorys() {
		return categoryStorage.getListOfCategory();
	}
	
	@Override
	public CategoryStorage getCategoryStorage() {
		return categoryStorage;
	}
	
	@Override
	public Category getCategory(int i) {
		return categoryStorage.getCategory(i);
	}
	
	public List<Project> getProjects(Category category) {
		return projectStorage.getSpecificProjects(category);
	}
}