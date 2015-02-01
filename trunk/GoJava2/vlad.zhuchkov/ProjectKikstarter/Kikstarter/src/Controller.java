public class Controller {

	public static void main(String[] args) {

		CategoryCatalog catalog = new CategoryCatalog();
		catalog.addCategory("games");
		catalog.addCategory("movies");
		catalog.addCategory("books");
		catalog.addCategory("programs");
		Controller app = new Controller();
		app.run(catalog, new Printer(), new Reader(new Printer()));
	}

	public void run(CategoryCatalog catalog, Printer printer, Reader reader) {
		QuoteConteiner quote = new QuoteConteiner();
		printer.print(quote.getQuote());
		int option;
		do {
			Category selectedCategory;
			do {
				selectedCategory = selectCategory(catalog, printer, reader);
				selectProject(printer, selectedCategory);
				option = reader.readInt();
			} while (option == 0);
			do {
				if (option == 0) {
					selectProject(printer, selectedCategory);
					option = reader.readInt() - 1;
				}
				Project selectedProject = selectedCategory.getProject(option);
				printer.showProjectInfo(selectedProject);
				printer.print("\npres 0 to return to project's list\npres 1 to exit\npres 2 to return to category's list ");
				option = reader.readInt();
			} while (option == 0);
		} while (option != 1);
	}

	private void selectProject(Printer printer, Category selectedCategory) {
		printer.showProjects(selectedCategory);
		printer.print("select project or 0 to change category");
	}

	private Category selectCategory(CategoryCatalog catalog, Printer printer,
			Reader reader) {
		printer.showCategoryCatalog(catalog);
		printer.print("select category (1-" + catalog.size() + " only)");
		int categoryNum = reader.readInt() - 1;
		Category selectedCategory = catalog.getCategory(categoryNum);
		printer.print("You select " + selectedCategory.getName() + "\n");
		return selectedCategory;
	}
	
}
