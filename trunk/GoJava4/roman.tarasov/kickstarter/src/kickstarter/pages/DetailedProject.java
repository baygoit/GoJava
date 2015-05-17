package kickstarter.pages;

import kickstarter.entities.QuestionsAndAnswers;
import kickstarter.entities.Project;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.Storage;

public class DetailedProject extends Page {

	ProjectRepository projects;

	private Storage<QuestionsAndAnswers> allComments;

	public DetailedProject(Storage<QuestionsAndAnswers> allComments,
			ProjectRepository projects) {

		this.allComments = allComments;
		this.projects = projects;
	}

	public QuestionsAndAnswers selectCommentsToProject(Project project) {
		if (project != null) {
			for (int index = 0; index < allComments.length(); index++) {
				if (allComments.getEntity(index).projectID == project.ID) {
					return allComments.getEntity(index);
				}
			}
		}
		return null;
	}

	public String getHeader() {
		int projectID = parameterForPrint;
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
		header += projects.printProjectsInfo(parameterForPrint);
		header += "\n------------------------";

		QuestionsAndAnswers comments = selectCommentsToProject(project);
		if (comments != null) {
			for (int index = 0; index < comments.getCommentLength(); index++) {
				header += "user ID:<" + comments.usersID[index]
						+ ">  comment:<" + comments.comment[index] + ">";
			}
		}
		return header;
	}

	public void print() {
	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {
		nextPage = 1;
		return;

	}
}
