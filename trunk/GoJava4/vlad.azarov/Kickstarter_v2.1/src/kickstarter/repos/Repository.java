package kickstarter.repos;

public class Repository {
	public QuotesRepo quotes;
	public CategoriesRepo categories;
	public ProjectsRepo projects;
	
	public Repository(QuotesRepo quotes, CategoriesRepo categories, ProjectsRepo projects) {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}
}
