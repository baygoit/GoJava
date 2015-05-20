package kickstarter.pages.model;

import kickstarter.mvc.iModel;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;

public class MComment extends PageModel {
	public MComment(CommentsRepository allComments, ProjectRepository projects,
			iModel imodel) {
		super(imodel);
		this.allComments = allComments;
		this.imodel = imodel;
		this.projects = projects;
	}

	public void execute(String message) {
		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}
		ModelOptions o = imodel.getModelOptions();
		int projectID = o.intSelectedProject;

		project = projects.getProjectById(projectID);
		projectComments = allComments.getCommentsByProjectID(project.ID);
		String[] array = message.split(":");
		if (array[0].equals("a") && array.length == 2) {
			// TODO
			projectComments.addComment(1, array[1]);// 1- user ID

			imodel.next(DETAILED_PROJECT);
			return;
		}
		if (array[0].equals("d") && array.length == 3) {
			try {
				projectComments.deleteComment(array[1], array[2]);
			} catch (NumberFormatException | NullPointerException e) {
				imodel.goToAndBack(ERROR_PAGE, COMMENT_PAGE);
				return;
			}
			imodel.next(DETAILED_PROJECT);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, COMMENT_PAGE);
	}
}
