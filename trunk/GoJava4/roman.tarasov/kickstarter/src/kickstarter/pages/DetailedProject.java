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
		int projectID = iOption;
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
				if (comments.usersID[index] != 0) {
					header += "user ID:<" + comments.usersID[index]
							+ ">  comment ID:<" + index + "> <"
							+ comments.comment[index] + ">\n";
				}
			}
		}
		header += "\n------------------------";
		header += "\nOptions: <p> - previous page; <i>- invest to project ; <c>- comment ; <d>- donate";
		return header;
	}

	public void execute(String message) {
		
		if (message.equals("p")) {
			navigator.nextWithOptions(PROJECTS, navigator.getSavedCategory(), "null");
			return;
		}
		if (message.equals("c")) {
			navigator.next(COMMENT_PAGE);
			return;
		}
		if (message.equals("i")) {
			navigator.nextWithOptions(INVEST_PAGE, iOption, "null");
			return;
		}
		if (message.equals("d")) {
			navigator.nextWithOptions(DONATE_PAGE, iOption, "null");
			return;
		}
		navigator.goToAndBack(ERROR_PAGE, DETAILED_PROJECT);

	}
}
