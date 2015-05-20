package kickstarter.interfaces;

import kickstarter.interfaces.pages.ChoicePage;
import kickstarter.interfaces.pages.Page;
import kickstarter.interfaces.pages.PagesManipulator;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;

public class UserInterface {
	public static final PagesManipulator PAGES = new PagesManipulator();

	private Printer printer;
	private Reader reader;

	public UserInterface(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}

	public void choiceItem(ChoicePage page) {
		while (true) {
			try {
				showPage(page);
				int itemId = Integer.parseInt(reader.getLine());
				page.setChosenItem(itemId);
				return;
			} catch (Exception ignore) {
			}
			printer.showMessage("--------------------");
			printer.showMessage("try again please");
		}
	}

	public void showPage(Page page) {
		printer.showMessage(page.getHead());
		printer.showMessage(page.getBody());
	}
}
