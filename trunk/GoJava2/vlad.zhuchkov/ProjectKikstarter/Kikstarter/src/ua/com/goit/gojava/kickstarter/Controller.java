package ua.com.goit.gojava.kickstarter;

import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;
import ua.com.goit.gojava.kickstarter.in_database_storage.InDBCatalog;
import ua.com.goit.gojava.kickstarter.in_memory_storage.Project;
import ua.com.goit.gojava.kickstarter.in_memory_storage.QuoteConteiner;
import ua.com.goit.gojava.kickstarter.input_output.ConsolePrinter;
import ua.com.goit.gojava.kickstarter.input_output.ConsoleReader;
import ua.com.goit.gojava.kickstarter.input_output.Input;
import ua.com.goit.gojava.kickstarter.input_output.Output;
import ua.com.goit.gojava.kickstarter.input_output.Printer;
import ua.com.goit.gojava.kickstarter.input_output.Reader;


public class Controller {
	private CategoryCatalog catalog;
	private Printer printer;
	private Reader reader;

	public Controller(Output out, Input in) {
		this.catalog = new InDBCatalog();
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
				printer.print("select category (1-" + catalog.size() + " only) or 0 to exit");
				
			}
		};
	}
	private Menu projectsMenu(final Category category){
		return new Menu(reader){

			@Override
			Menu nextMenu(Object selected) {
				Project project = (Project)selected;
				printer.showProjectInfo(project);
				printer.print("input eny unmber to return");
				reader.readInt();
				return null;
			}
			
			@Override
			Object choose(int menu) {	
				Project project = null;
				try{
					if (menu == -1)
						return null;
				project = category.getProject(menu-1);
				}catch(IlligalInputException e){
					ask(); 
					menu = reader.readInt();
                     Object selected = choose(menu);
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
