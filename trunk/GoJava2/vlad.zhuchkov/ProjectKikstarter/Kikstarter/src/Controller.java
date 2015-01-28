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

	private void printProjects(Printer printer, Category selectedCategory) {
		printer.showProjects(selectedCategory);
		printer.print("Select project for more details\n0 - up");

	}

	public void run() {
		int option = 0;
		int projectNum = 0;
		Printer printer = new Printer();

		QuoteConteiner quote = new QuoteConteiner();
		printer.print(quote.getQuote());

		Category selectedCategory = null;
		Reader reader = new Reader();
		do {

			do {

				printer.showCategoryCatalog(catalog);
				printer.print("select category (1-" + catalog.size() + " only)");
				option = reader.readInt() - 1;
				selectedCategory = catalog.getCategory(option);
				printer.print("\nYou select " + selectedCategory.getName());
				printProjects(printer, selectedCategory);
				projectNum = reader.readInt() - 1;
			} while (projectNum == -1);
			do {
				if (option == -1) {

					printProjects(printer, selectedCategory);
					option = reader.readInt() - 1;

				}
				if (option != -1) {
					projectNum = option;
					Project selectedProject = null;
					selectedProject = selectedCategory.getProject(projectNum);
					printer.showProjectInfo(selectedProject);
					do {
						printer.print("\npres 0 to return to project's list\npres 1 to exit\npres 2 to return to category's list ");
						option = reader.readInt() - 1;
						if (option > 2) {
							printer.print("only 0-2 required");
						}
					} while (option > 2);
				}
				else {
					option = 1;
				}
			} while (option == -1);
			

		} while (option == 1);
	}
}
