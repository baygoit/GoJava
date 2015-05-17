package kickstarter.pages;

import kickstarter.entities.QuestionsAndAnswers;
import kickstarter.entities.Project;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.Storage;
import kickstarter.ui.UserInterface;

public class DetailedProject extends Page {

	ProjectRepository projects;
	private UserInterface ui;
	private Storage<QuestionsAndAnswers> allComments;

	public DetailedProject(UserInterface ui, Storage<QuestionsAndAnswers> allComments,
			ProjectRepository projects) {
		this.ui = ui;
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

	public void print() {
		int projectID = parameterForPrint;

		Project project = projects.getProjectById(projectID);

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

		QuestionsAndAnswers comments = selectCommentsToProject(project);
		if (comments != null) {
			for (int index = 0; index < comments.getCommentLength(); index++) {
				ui.display("user ID:<" + comments.usersID[index]
						+ ">  comment:<" + comments.comment[index] + ">");
			}
		}
		ui.display("------------------------");

	}

	public String[] getOptions() {
		return options;
	}

	public void execute(String message) {

		nextPage = 1;

		System.out.println(parameterForPrint + ".......");
		// parameterForPrint=optionsInt[index];
		return;

	}
}
