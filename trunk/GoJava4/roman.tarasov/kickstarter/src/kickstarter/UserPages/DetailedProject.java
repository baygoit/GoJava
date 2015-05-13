package kickstarter.UserPages;

import kickstarter.UserInterface;
import kickstarter.Entities.Comments;
import kickstarter.Entities.Project;
import kickstarter.Repository.Storage;

public class DetailedProject {

	private UserInterface ui;
	Storage<Comments> allComments;

	public DetailedProject(UserInterface ui, Storage<Comments> allComments) {
		this.ui = ui;
		this.allComments = allComments;
	}

	public Comments selectCommentsToProject(Project project) {
		if (project != null) {
			for (int index = 0; index < allComments.length(); index++) {
				if (allComments.getEntity(index).projectID == project.id) {
					return allComments.getEntity(index);
				}
			}
		}
		return null;
	}

	public void getDetailedInfo(Project project, Storage<Comments> allComments) {
		ui.display("________________________");
		ui.display("|Detailed project info |");
		ui.display("|______________________|");
		ui.display("name     :<" + project.name + ">");
		ui.display("ID       :<" + project.id + ">");
		ui.display("description:<" + project.description + ">");
		ui.display("goal     :<" + project.goal + ">");
		ui.display("pledged  :<" + project.pledged + ">");
		ui.display("days to go :<" + project.daysToGo + ">");
		ui.display("history :<" + project.history + ">");
		ui.display("link to video :<" + project.linkToVideo + ">");
		ui.display("comments :");

		Comments comments = selectCommentsToProject(project);
		if (comments != null) {
			for (int index = 0; index < comments.getCommentLength(); index++) {
				ui.display("user ID:<" + comments.usersID[index]
						+ ">  comment:<" + comments.comment[index] + ">");
			}
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
