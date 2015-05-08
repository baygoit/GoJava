package kickstarter;

public class PageUserProjectsView extends Page {
	ProjectList projects;

	public PageUserProjectsView(ProjectList projects) {
		this.projects = projects;
	}

	int[] printProjects() {
		return projects.printList(ui);
	}

	@Override
	public Page getNextPage() {
		ui.display("________________________");
		ui.display("|     Projects         |");
		ui.display("|______________________|");
		int[] options = printProjects();
		ui.display("------------------------");
		ui.display("Select Project:");
		while (true) {
			ui.display(" e- exit to Categories ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return pages[USER_CATEGORIES_VIEW];
			}
			// TODO
			try {
				int parsed = Integer.parseInt(stringFromUI);

				for (int index = 0; index < options.length; index++) {
					if (parsed == options[index]) {

						projectToProjectView = projects.get(index);
						projects.setTargetCategory(categoryToUserProjectsView);
						return pages[PAGE_LOGIN];
					}
				}
				throw new IndexOutOfBoundsException();
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				ui.display("input correct command, please");
			}
		}
	}
}
