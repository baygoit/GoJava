package kickstarter;

public class DetailedProjectInfo extends Page {
	ProjectList projects;

	public DetailedProjectInfo(ProjectList projects) {
		this.projects = projects;
	}

	@Override
	public Page getNextPage() {
		ui.display("________________________");
		ui.display("|Detailed project info |");
		ui.display("|______________________|");
		ui.display("category : " + projects.targetProject.category.name);
		ui.display("name     : " + projects.targetProject.name);
		ui.display("id       : " + projects.targetProject.id);
		ui.display("goal     : " + projects.targetProject.goal);
		ui.display("pledged  : " + projects.targetProject.pledged);
		ui.display("expire date     : " + projects.targetProject.expireDate);

		ui.display("------------------------");
		while (true) {
			ui.display(" e- exit to Categories ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return pages[USER_CATEGORIES_VIEW];
			}
			ui.display("input correct command, please");
		}
	}
}
