package kickstarter.pages.viewContent;

import kickstarter.entities.ProjectComments;
import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.repository.facade.Repository;

public class DetailedProject extends PageView {

	public DetailedProject(Repository repository, iModel imodel) {
		this.repository = repository;
		this.imodel = imodel;
	}

	private ProjectComments selectCommentsToProject(int projectID) {
		ProjectComments comments = repository.getCommentsByProjectID(projectID);
		return comments;
	}

	public String getHeader() {
		int projectID = imodel.getModelOptions().intSelectedProject;
		Project project = repository.getProjectById(projectID);
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
							+ comments.getComment()[index] + ">\n";
				}
			}
		}
		header += "\n------------------------";
		header += "\nOptions: <p> - previous page; <i>- invest to project ; <c>- comment ; <d>- donate";
		return header;
	}
}
