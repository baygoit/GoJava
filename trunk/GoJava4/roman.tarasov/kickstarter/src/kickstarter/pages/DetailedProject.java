package kickstarter.pages;

import kickstarter.entities.ProjectComments;
import kickstarter.entities.Project;
import kickstarter.mvc.Model;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.CommentsRepository;

public class DetailedProject extends Page {

	public DetailedProject(CommentsRepository allComments,
			ProjectRepository projects, Model model) {
		this.navigator = model;
		this.allComments = allComments;
		this.projects = projects;

	}

	public ProjectComments selectCommentsToProject(int projectID) {
		ProjectComments comments = allComments
				.getCommentsByProjectID(projectID);
		return comments;
	}

	public String getHeader() {
		int projectID = parameterForPage;
		Project project = projects.getProjectById(projectID);

		String header = "";
		header += "\n________________________";
		header += "\n|Detailed project info |";
		header += "\n|______________________|";
		header += "\nname     :<" + project.name + ">";
		header += "\nID       :<" + project.ID + ">";
		header += "\ndescription:<" + project.description + ">";
		header += "\ngoal     :<" + project.goal + ">";
		header += "\npledged  :<" + project.pledged + ">";
		header += "\ndays to go :<" + project.daysToGo + ">";
		header += "\nhistory :<" + project.history + ">";
		header += "\nlink to video :<" + project.linkToVideo + ">";
		header += "\ncomments :";
		header += "\n";

		ProjectComments comments = selectCommentsToProject(project.ID);
		if (comments != null) {
			for (int index = 0; index < comments.getCommentLength(); index++) {
				header += "user ID:<" + comments.usersID[index]
						+ ">  comment:<" + comments.comment[index] + ">\n";
			}
		}
		header += "\n------------------------";
		header += "\nOptions: <p> - previous page; <i>- invest to project ; <c>- comment";
		return header;
	}

	public void viewWorkedStatus(int status) {
	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {
		navigator.saveProject(parameterForPage);
		if (message.equals("p")) {
			navigator.pageWillBe(PROJECTS);
			navigator.setOption(navigator.getSavedCategory(), "null");
			return;
		}
		if (message.equals("c")) {
			navigator.pageWillBe(COMMENT_PAGE);
			return;
		}
		navigator.savePageBeforeError(DETAILED_PROJECT);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
