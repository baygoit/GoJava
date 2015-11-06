package ua.com.goit.gojava7.kickstarter;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = new QuoteStorage();
		StringConsolePrinter.println(quoteStorage.getRandomQuote());
		ProjectStorage projectStorage = new ProjectStorage();
		// add project in category 0
		projectStorage.setProject(new Project("THE BOONDOCK SAINTS",
				"The Boondock Saints is a 1999 American crime film written and directed by Troy Duffy",
				100000000D, 180), 0);

		CategoryStorage categoryStorage = new CategoryStorage();
		// creating of categories
		categoryStorage.setCategory("Movie");
		categoryStorage.setCategory("Art");
		categoryStorage.setCategory("Food");

		// show all categories with index
		CategoryListConsolePrinter.println(categoryStorage);

		// ask user to select 1
		StringConsolePrinter.println("Chose the category");

		// read user input
		UserCategorySelect selectedCategory = new UserCategorySelect();

		CategoryConsolePrinter.println(categoryStorage
				.getCategory(selectedCategory.getCategoryNumber()));

		// show selected category
		// StringConsolePrinter.println(categoryStorage
		// .getCategory(selectedCategory.getCategoryNumber()));

	}
}
