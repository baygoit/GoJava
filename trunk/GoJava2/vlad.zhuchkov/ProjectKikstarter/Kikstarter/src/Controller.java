public class Controller {
	private CategoryCatalog catalog;
	private Printer printer;
	private Reader reader;

	public Controller(Output out, Input in) {
		this.catalog = new InFileCategoryCatalog();
		catalog.addCategory("games");
		catalog.addCategory("movies");
		catalog.addCategory("books");
		catalog.addCategory("programs");
		this.printer = new Printer(out);
		this.reader = new Reader(in);
	}

	public static void main(String[] args) {
		Controller app = new Controller(new ConsolePrinter(),
				new ConsoleReader());
		app.run();
	}

	public void run() {
		QuoteConteiner quote = new QuoteConteiner();
		printer.print(quote.getQuote());
		categoryMenu().run();
		
	}
	private Menu categoryMenu(){
		return new Menu(reader){
			@Override
			Menu nextMenu(Object selected){
				Category category = (Category)selected;
				return projectsMenu(category);
				}

			@Override
			Object choose(int menu) {				
				return selectCategory(menu);
			}

			@Override
			void ask() {
				printer.showCategoryCatalog(catalog);
				printer.print("select category (1-" + catalog.size() + " only)");
				
			}
		};
	}
	private Menu projectsMenu(final Category category){
		return new Menu(reader){

			@Override
			Menu nextMenu(Object selected) {
				Project project = (Project)selected;
				printer.showProjectInfo(project);
				printer.print("pres eny unmber to proceed");
				reader.readInt();
				return null;
			}
			
			@Override
			Object choose(int menu) {	
				Project project = null;
				try{
					if (menu == -1)
						return null;
				project = category.getProject(menu);
				}catch(IlligalInputException e){
					ask(); 
					menu = reader.readInt();
                     Object selected = choose(menu-1);
				}
				return project;
			}

			@Override
			void ask() {
				selectProject(category);
			}
			
		};
	}

	private void selectProject(Category selectedCategory) {
		printer.showProjects(selectedCategory);
		printer.print("select project or 0 to change category");
	}

	private Category selectCategory(int menu) {
		Category selectedCategory = catalog.getCategory(menu);
		printer.print("You select " + selectedCategory.getName() + "\n");
		return selectedCategory;
	}

}
