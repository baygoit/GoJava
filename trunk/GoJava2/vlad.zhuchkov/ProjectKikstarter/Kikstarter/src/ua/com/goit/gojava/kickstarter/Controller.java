package ua.com.goit.gojava.kickstarter;

import java.sql.Connection;
import java.sql.SQLException;

import ua.com.goit.gojava.kickstarter.dao.ConnectionPool;
import ua.com.goit.gojava.kickstarter.dao.CatalogDao;
import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.CategoryCatalog;
import ua.com.goit.gojava.kickstarter.data.Project;
import ua.com.goit.gojava.kickstarter.data.QuoteConteiner;
import ua.com.goit.gojava.kickstarter.input.ConsoleReader;
import ua.com.goit.gojava.kickstarter.input.Input;
import ua.com.goit.gojava.kickstarter.input.Reader;
import ua.com.goit.gojava.kickstarter.output.ConsolePrinter;
import ua.com.goit.gojava.kickstarter.output.Output;
import ua.com.goit.gojava.kickstarter.output.Printer;
import ua.com.goit.gojava.kickstarter.payment.PaymentSystem;

public class Controller {
	private CategoryCatalog catalog;
	private Printer printer;
	private Reader reader;
	private PaymentSystem paymentSystem;

	public Controller(Output out, Input in, CategoryCatalog catalog,
			PaymentSystem paymentSystem) {
		printer = new Printer(out);
		reader = new Reader(in);
		this.catalog = catalog;
		this.paymentSystem = paymentSystem;

	}

	public static void main(String[] args) {
		ConnectionPool pool = new ConnectionPool();
		Connection c = pool.getConnection();
		PaymentSystem ps = new PaymentSystem(c);
		CategoryCatalog catalog = new CatalogDao(c);
		Controller app = new Controller(new ConsolePrinter(),
				new ConsoleReader(), catalog, ps);
		app.run();
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		QuoteConteiner quote = new QuoteConteiner();
		printer.print(quote.getQuote());
		categoryMenu().run();

	}

	private Menu categoryMenu() {
		return new Menu(reader) {
			@Override
			Menu nextMenu(Object selected) {
				Category category = (Category) selected;
				return projectsMenu(category);
			}

			@Override
			Object choose(int menu) {
				return selectCategory(menu);
			}

			@Override
			void ask() {
				printer.showCategoryCatalog(catalog);
				printer.print("select category (1-" + catalog.size()
						+ " only) or 0 to exit");

			}
		};
	}

	private Menu projectsMenu(final Category category) {
		return new Menu(reader) {

			@Override
			Menu nextMenu(Object selected) {
				Project project = (Project) selected;
				printer.showProjectInfo(project);
				printer.print("Donate?*soon* 1-yes/2-no");
				int option = reader.readInt();
				if (option == 1) {
					try {
						paymentSystem.pay(reader.readInt(), (Project) selected);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				printer.print("input eny unmber to return");
				reader.readInt();
				return null;
			}

			@Override
			Object choose(int menu) {
				if (menu == -1)
					return null;
				Project project = category.getProject(menu - 1);
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
