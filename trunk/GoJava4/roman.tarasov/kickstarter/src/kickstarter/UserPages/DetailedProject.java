package kickstarter.UserPages;

import kickstarter.UserInterface;
import kickstarter.Entities.Project;

public class DetailedProject {

	private UserInterface ui;

	public DetailedProject(UserInterface ui) {
		this.ui = ui;
	}

	public void getDetailedInfo(Project project) {
		ui.display("________________________");
		ui.display("|Detailed project info |");
		ui.display("|______________________|");
		ui.display("name     :<" + project.name+">");
		ui.display("ID       :<" + project.id+">");
		ui.display("description:<" + project.description+">");
		ui.display("goal     :<" + project.goal+">");
		ui.display("pledged  :<" + project.pledged+">");
		ui.display("days to go :<" + project.daysToGo+">");
		ui.display("history :<" + project.history+">");
		ui.display("link to video :<" + project.linkToVideo+">");
		ui.display("comments :");
		for (int index=0;index<project.getCommentLength();index++){
			ui.display("user ID:<"+project.usersID[index]+">  comment:<"+project.comment[index]+">");
		}

		ui.display("------------------------");
		while (true) {
			ui.display(" e- exit to Categories ");
			String stringFromUI = ui.inputString();
			if (stringFromUI.equals("e")) {
				ui.display("exit");
				return;
			}
			ui.display("input correct command, please");
		}
	}
}
