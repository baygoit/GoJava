package kickstarter.pages.viewContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.repository.facade.RepositoryException;

public class Comment extends PageView {

	public String getHeader() throws RepositoryException {
		modelValues = imodel.getModelValues();
		Project project = repository
				.getProjectById(modelValues.getIntSelectedProject());

		StringBuilder header = new StringBuilder();
		header.append("\n_________________________");
		header.append("\n|Add comment to project  |");
		header.append("\n|________________________|");
		header.append("\nname     :<");
		header.append(project.getName());
		header.append(">");
		header.append("\nID       :<");
		header.append(project.getID());
		header.append(">");
		header.append("\ndescription:<");
		header.append(project.getDescription());
		header.append(">");
		header.append("\ngoal     :<");
		header.append(project.getGoal());
		header.append(">");
		header.append("\npledged  :<");
		header.append(project.getPledged());
		header.append(">");
		header.append("\ndays to go :<");
		header.append(project.getDaysToGo());
		header.append(">");
		header.append("\nhistory :<");
		header.append(project.getHistory());
		header.append(">");
		header.append("\nlink to video :<");
		header.append(project.getLinkToVideo());
		header.append(">");
		header.append("\ncomments :");
		header.append("\n");

		ProjectComments projectComments = repository
				.getCommentsByProjectID(project.getID());

		if (projectComments != null) {
			for (int index = 0; index < projectComments.getCommentLength(); index++) {
				if (projectComments.usersID[index] != 0) {
					header.append("user ID:<");
					header.append(projectComments.usersID[index]);
					header.append(">  comment ID:<");
					header.append(index);
					header.append("> <");
					header.append(projectComments.getComment()[index]);
					header.append(">\n");
				}
			}
		}
		header.append("\n------------------------");
		header.append("\nAdd comment in format :     <a:my comment>");
		header.append("\nDelete comment in format :  <d:3:0>            where 3- user ID, 0- comment ID ");
		header.append("\nOptions: <p>- previous page  ");
		return header.toString();
	}
}
