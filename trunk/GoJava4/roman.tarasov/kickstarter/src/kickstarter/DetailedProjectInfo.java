package kickstarter;

public class DetailedProjectInfo  {
	ProjectList projects;
	UserInterface ui;
	public DetailedProjectInfo( UserInterface ui) {
		this.projects = projects;
		this.ui=ui;
	}

	void getDetailedInfo(Project project) {
		ui.display("________________________");
		ui.display("|Detailed project info |");
		ui.display("|______________________|");
		ui.display("category : " + project.category.name);
		ui.display("name     : " + project.name);
		ui.display("id       : " + project.id);
		ui.display("goal     : " + project.goal);
		ui.display("pledged  : " + project.pledged);
		ui.display("expire date     : " + project.expireDate);

		ui.display("------------------------");
		while (true) {
			ui.display(" e- exit to Categories ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return ;
			}
			ui.display("input correct command, please");
		}
	}


}
