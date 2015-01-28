public class Controller {
	private CategoryCatalog catalog;

	public Controller(CategoryCatalog catalog) {
		this.catalog = catalog;
	}

	public static void main(String[] args) {

		CategoryCatalog catalog = new CategoryCatalog();
		catalog.addCategory("games");
		catalog.addCategory("movies");
		catalog.addCategory("books");
		catalog.addCategory("programs");
		Controller app = new Controller(catalog);
		app.run();

	}

	public void run() {
		int option = 0;
		Printer printer = new Printer();

		QuoteConteiner quote = new QuoteConteiner();
		printer.print(quote.getQuote());
		printer.print("select category (1-" + catalog.size() + " only)");

		Category selectedCategory = null;
		Reader reader = new Reader();
		do {

			do {
				printer.showCategoryCatalog(catalog);
				option = reader.readInt() - 1;
				selectedCategory = catalog.getCategory(option);
				printer.print("You select " + selectedCategory.getName());
				printer.print("select project");
				printer.showProjects(selectedCategory);
				printer.print("Select project for more details\n 0 - up ");
				option = reader.readInt() - 1;
			} while (option == -1);
			do {
				Project selectedProject = null;
				selectedProject = selectedCategory.getProject(option);
				printer.showProjectInfo(selectedProject);
				System.out.println("0 up");
				option = reader.readInt() - 1;
				if(option == -1)
				{
					printer.print("select project");
					printer.showProjects(selectedCategory);
					printer.print("Select project for more details\n 0 - up ");
					option = reader.readInt() - 1;
				}
			} while (option == 0);
		} while (true);
	}
}
