package kickstarter.pages;

import kickstarter.entities.Comments;
import kickstarter.entities.Project;
import kickstarter.repository.Storage;
import kickstarter.ui.UserInterface;

public class DetailedProject extends Page {
	private Storage<Project> projects;
	private UserInterface ui;
	Project project;
	Storage<Comments> allComments;

	public DetailedProject(UserInterface ui, Storage<Comments> allComments,
			Storage<Project> projects) {
		this.ui = ui;
		this.allComments = allComments;
		this.projects = projects;
	}

	public Comments selectCommentsToProject(Project project) {
		if (project != null) {
			for (int index = 0; index < allComments.length(); index++) {
				if (allComments.getEntity(index).projectID == project.ID) {
					return allComments.getEntity(index);
				}
			}
		}
		return null;
	}

	public int[] getOptions() {
		return null;
	}

	void getProjectByID(int projectID) {
		for (int index = 0; index < projects.length(); index++) {
			if (projects.getEntity(index).ID == projectID) {
				project = projects.getEntity(index);
				return;
			}
		}
		project = null;
	}

	public void print(int[] parameterForPrint) {
		int projectID = parameterForPrint[0];
		getProjectByID(projectID);

		ui.display("________________________");
		ui.display("|Detailed project info |");
		ui.display("|______________________|");
		ui.display("name     :<" + project.name + ">");
		ui.display("ID       :<" + project.ID + ">");
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
	}
}
