package kickstarter.mvc;

import kickstarter.pages.Page;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;
import kickstarter.ui.UserInterface;

public class Model {
	Storage<Page> pages;
	private UserInterface ui;
	int[] options;
	int[] parameterForPrint;
	int pageIndex;
	final int CATEGORIES = 0;
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	Page page;
	String[] stringCommands = { "Select category by ID ; e - End",
			"Select project by ID ; c - to Category Page", "c - to Category Page" };

	public Model(UserInterface ui) {
		pages = new EntityStorage<Page>();
		this.ui=ui;
	}

	public int[] getParameterForPrint() {
		return parameterForPrint;
	}

	public void add(Page page) {
		pages.add(page);
	}

	public void setPage(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public Page getPage() {
		return pages.getEntity(pageIndex);
	}

	void doCommandForCategoriesPage(String command) {
		if (command.equals("e")) {
			ui.display("Good Bye");
			System.exit(0);
		}
		int parsed;
		try {
			parsed = Integer.parseInt(command);
			for (int index = 0; index < options.length; index++) {
				if (parsed == options[index]) {
					pageIndex = PROJECTS;
					parameterForPrint = new int[] { parsed };
					return;
				}
			}
			throw new IndexOutOfBoundsException();
		} catch (NullPointerException | NumberFormatException
				| IndexOutOfBoundsException e) {
			ui.display("input correct command, please");
			return;
		}
	}

	void doCommandForProjectsPage(String command) {
		if (command.equals("c")) {
			pageIndex = CATEGORIES;
			return;
		}
		int parsed;
		try {
			parsed = Integer.parseInt(command);
			for (int index = 0; index < options.length; index++) {
				if (parsed == options[index]) {
					pageIndex = DETAILED_PROJECT;
					parameterForPrint = new int[] { parsed };
					return;
				}
			}
			throw new IndexOutOfBoundsException();
		} catch (NullPointerException | NumberFormatException
				| IndexOutOfBoundsException e) {
			ui.display("input correct command, please");
			return;
		}
	}

	void doCommandForDetailedProjectPage(String command) {

		if (command.equals("c")) {
			pageIndex = CATEGORIES;
			return;
		}
		ui.display("input correct command, please");
	}

	public void execute(String command) {
		switch (pageIndex) {
		case CATEGORIES:
			doCommandForCategoriesPage(command);
			break;
		case PROJECTS:
			doCommandForProjectsPage(command);
			break;
		case DETAILED_PROJECT:
			doCommandForDetailedProjectPage(command);
			break;
		default:
			doCommandForCategoriesPage(command);
		}
	}

	public void setOptions(int[] options) {
		this.options = options;
	}
}
