package kickstarter;

public class Category {
	String [] category;

	Category(Repository repository) {
		this.category=repository.categories;
	}
}
