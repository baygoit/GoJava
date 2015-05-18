package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.Model;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;

public class CommentPage extends Page {
	ProjectComments projectComments;
	Project project;

	public CommentPage(CommentsRepository allComments, Model model,
			ProjectRepository projects) {
		this.navigator = model;
		this.allComments = allComments;
		this.projects = projects;

	}

	public void viewWorkedStatus(int status) {
	}

	public String getHeader() {
		int projectID = parameterForPage;
		project = projects.getProjectById(projectID);

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

		projectComments = allComments.getCommentsByProjectID(project.ID);

		if (projectComments != null) {
			for (int index = 0; index < projectComments.getCommentLength(); index++) {
				if (projectComments.usersID[index] != 0) {
					header += "user ID:<" + projectComments.usersID[index]
							+ ">  comment ID:<" + index + "> <"
							+ projectComments.comment[index] + ">\n";
				}
			}
		}
		header += "\n------------------------";
		header += "\nAdd comment in format :     <a:my comment>";
		header += "\nDelete comment in format :  <d:0:1>            where 3- user ID, 0- comment ID ";
		header += "\nOptions: <p>- previous page  ";
		return header;
	}

	public void execute(String message) {
		navigator.saveProject(parameterForPage);
		if (message.equals("p")) {
			navigator.pageWillBe(DETAILED_PROJECT);
			return;
		}
		String[] array = message.split(":");
		if (array[0].equals("a") && array.length == 2) {
			// TODO
			projectComments.addComment(1, array[1]);// 1- user ID

			navigator.pageWillBe(DETAILED_PROJECT);
			return;

		}
		if (array[0].equals("d") && array.length == 3) {
			try {
				projectComments.deleteComment(array[1], array[2]);
			} catch (NumberFormatException | NullPointerException e) {
				navigator.savePageBeforeError(COMMENT_PAGE);
				navigator.pageWillBe(ERROR_PAGE);
				return;
			}

			navigator.pageWillBe(DETAILED_PROJECT);
			return;
		}
		navigator.savePageBeforeError(COMMENT_PAGE);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
