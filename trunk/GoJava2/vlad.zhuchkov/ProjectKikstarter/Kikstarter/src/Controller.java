import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		boolean inputRight = true;
		int option = 0;
		Category selectedCategory = null;
		Project selectedProject = null;
		Scanner sc = new Scanner(System.in);
		ConsoleWriter writer = new ConsoleWriter();
		QuoteConteiner quote = new QuoteConteiner();
		System.out.println(quote.getQuote());

		Category games = new Category("games");
		Category movies = new Category("movies");
		Category books = new Category("books");
		Category programs = new Category("programs");

		CategoryCatalog catalog = new CategoryCatalog();
		catalog.addCategory(games);
		catalog.addCategory(movies);
		catalog.addCategory(books);
		catalog.addCategory(programs);
		System.out.println("select category 1-" + catalog.size());
		writer.showCategoryCatalog(catalog);
		do {
			try {
				option = Integer.valueOf(sc.nextLine()) - 1;
				selectedCategory = catalog.getCategory(option);
				System.out.println("You select " + selectedCategory.getName());
				System.out.println("select project");
				inputRight = true;
			} catch (NumberFormatException Integer) {
				System.out.println("invalid input");
				inputRight = false;
			} catch (IndexOutOfBoundsException ArrayList) {
				System.out.println("invalid input");
				inputRight = false;
			}
		} while (!inputRight);
		writer.showCategoryProjects(selectedCategory);
		System.out.println("Select project for more details ");
		do {
			try {
				option = Integer.valueOf(sc.nextLine()) - 1;
				selectedProject = selectedCategory.getProject(option);
				inputRight = true;
			} catch (NumberFormatException Integer) {
				System.out.println("invalid input");
				inputRight = false;
			} catch (IndexOutOfBoundsException ArrayList) {
				System.out.println("invalid input");
				inputRight = false;
			}
		} while (!inputRight);
		writer.showProjectInfo(selectedProject);
		sc.close();
	}
}
