package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.Model;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;

public class CommentPage extends Page {
	public CommentPage(CommentsRepository allComments, Model model,ProjectRepository projects) {
		this.navigator = model;
		this.allComments = allComments;
		this.projects = projects;

	}
	public void viewWorkedStatus(int status) {
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
		header += "\n_________________________";
		header += "\n|Add comment to project  |";
		header += "\n|________________________|";
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
		header += "\nAdd comment in format :     </my comment/>";
		header += "\nDelete comment in format :  <d:0>            where 0 - ID of comment ";
		header += "\nOptions: <p>- previous page  ";
		return header;
	}
	public void execute(String message) {
		navigator.saveProject(parameterForPage);
		if (message.equals("p")) {
			navigator.pageWillBe(DETAILED_PROJECT);
			//navigator.setOption(navigator.getSavedCategory(), "null");
			return;
		}

		navigator.savePageBeforeError(COMMENT_PAGE);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
