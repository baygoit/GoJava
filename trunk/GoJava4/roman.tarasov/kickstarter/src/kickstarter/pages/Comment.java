package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;

public class Comment extends PageView {
	ProjectComments projectComments;
	Project project;

	public Comment(CommentsRepository allComments, ProjectRepository projects) {

		this.allComments = allComments;
		this.projects = projects;
	}

	public String getHeader() {
		int projectID = intOption;
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
		header += "\nDelete comment in format :  <d:3:0>            where 3- user ID, 0- comment ID ";
		header += "\nOptions: <p>- previous page  ";
		return header;
	}
}
