package kickstarter.page;

import java.io.IOException;
import java.util.Map;

import kickstarter.logic.CategoriesLogic;
import kickstarter.printer.Printer;
import kickstarter.reader.Reader;
import kickstarter.repos.Repository;

public class CategoriesPage implements IPage {

	private String data;
	private String header;
	private CategoriesLogic categoriesLogic;
	private String footer;
	private Printer printer;
	private Reader reader;
	private String exit;
	private Repository repository;

	public CategoriesPage(Printer printer, Reader reader, Repository repository2) {
		categoriesLogic = new CategoriesLogic(repository);
		this.printer = printer;
		this.data = "";
		this.header = "Please enter the number of the category you want to choose or press \"0\" to leave the programm:\n";
		this.footer = "====";
		this.exit = "Bye";
	}

	public void run(Map<String, String> choice) {
		if (data == "") {
			addQuote();
			showHeader();
			for (int index = 0; index < categoriesLogic.getSize(); index++) {
				addData(index, categoriesLogic.getIndex(index));
			}
			showData();
			showFooter();
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}

	@Override
	public State makeChoice(Map<String, String> choice) throws IOException {
		int categoryChoise = new InputData(printer, reader).inputData(categoriesLogic.getSize());
		choice.put("categoryChoice", Integer.toString(categoryChoise));

		if (categoryChoise == 0) {
			showExit();
			System.exit(0);
			return State.CATEGORIES;
		} else {
			return State.PROJECTS;
		}
	}

	private void showExit() {
		printer.println(exit);
		
	}

	private void addData(int index, String category) {
		data += Integer.toString(index + 1) + ". " + category + "\n";
	}

	private void showFooter() {
		printer.println(footer);
	}

	private void showData() {
		printer.println(data);
	}

	private void showHeader() {
		printer.println(header);

	}

	private void addQuote() {
		header = categoriesLogic.getQuote() + "\n\n" + header;
	}

}
