public class Controller {
	private CategoryCatalog catalog;
	private Printer printer;
	private Reader reader;

	public Controller(Output out,Input in){
		this.catalog = new CategoryCatalog();
		catalog.addCategory("games");
		catalog.addCategory("movies");
		catalog.addCategory("books");
		catalog.addCategory("programs");
		this.printer = new Printer(out);
		this.reader=new Reader(in);
	}
	public static void main(String[] args) {
		Controller app = new Controller(new ConsolePrinter(), new ConsoleReader());
		app.run();
	}

	public void run() {
		QuoteConteiner quote = new QuoteConteiner();
		printer.print(quote.getQuote());
		int option;
		do {
			Category selectedCategory;
			do {
				selectedCategory = selectCategory(catalog);
				selectProject(selectedCategory);
				option = reader.readInt();
			} while (option == 0);
			do {
				if (option == 0) {
					selectProject(selectedCategory);
					option = reader.readInt();
				}
				Project selectedProject = selectedCategory.getProject(option-1);
				printer.showProjectInfo(selectedProject);
				printer.print("\npres 0 to return to project's list\npres 1 to exit\npres 2 to return to category's list ");
				option = reader.readInt();
			} while (option == 0);
		} while (option != 1);
	}

	private void selectProject(Category selectedCategory) {
		printer.showProjects(selectedCategory);
		printer.print("select project or 0 to change category");
	}

	private Category selectCategory(CategoryCatalog catalog) {
		printer.showCategoryCatalog(catalog);
		printer.print("select category (1-" + catalog.size() + " only)");
		int categoryNum = reader.readInt() - 1;
		Category selectedCategory = catalog.getCategory(categoryNum);
		printer.print("You select " + selectedCategory.getName() + "\n");
		return selectedCategory;
	}
	
}
