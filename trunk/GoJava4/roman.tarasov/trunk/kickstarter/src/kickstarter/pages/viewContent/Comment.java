package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.repository.facade.Repository;

public class Comment extends PageView {

	public Comment(Repository repository, iModel imodel) {
		this.repository = repository;

		this.imodel = imodel;
	}

	public String getHeader() {
		modelOptions = imodel.getModelOptions();
		project = repository.getProjectById(modelOptions.intSelectedProject);

		StringBuilder header = new StringBuilder();
		header.append("\n_________________________");
		header.append("\n|Add comment to project  |");
		header.append("\n|________________________|");
		header.append("\nname     :<");
		header.append(project.name);
		header.append(">");
		header.append("\nID       :<" + project.ID + ">");
		header.append("\ndescription:<" + project.description + ">");
		header.append("\ngoal     :<" + project.goal + ">");
		header.append("\npledged  :<" + project.pledged + ">");
		header.append("\ndays to go :<" + project.daysToGo + ">");
		header.append("\nhistory :<" + project.history + ">");
		header.append("\nlink to video :<" + project.linkToVideo + ">");
		header.append("\ncomments :");
		header.append("\n");

		projectComments = repository.getCommentsByProjectID(project.ID);

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
