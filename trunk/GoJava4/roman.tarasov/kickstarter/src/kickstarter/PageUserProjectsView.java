package kickstarter;

public class PageUserProjectsView extends Page {
	ProjectList projects;

	public PageUserProjectsView(ProjectList projects) {
		this.projects = projects;
	}

	void printProjects() {
		projects.printList(ui);
	}

	@Override
	public Page getNextPage() {
		ui.display("________________________");
		ui.display("|     Projects         |");
		ui.display("|______________________|");
		printProjects();
		ui.display("------------------------");
		ui.display("Select Project:");
		while (true) {
			ui.display(" e- exit to Login Page");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return pages[PAGE_LOGIN];
			}
			//TODO
			try {
				int parsed = Integer.parseInt(stringFromUI);
				projectToProjectView = projects.get(parsed);
				return pages[PAGE_LOGIN];
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				// throw new IllegalArgumentException();
				ui.display("input correct command, please");
				continue;
			}

		}
	}
}
