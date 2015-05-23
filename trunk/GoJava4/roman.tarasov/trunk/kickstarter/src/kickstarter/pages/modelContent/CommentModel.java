package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.repository.facade.Repository;

public class CommentModel extends PageModel {
	public CommentModel(Repository repository, iModel imodel) {
		super(imodel);
		this.repository = repository;
		this.imodel = imodel;

	}

	@Override
	public void update(String message) {
		if (message.equals("p")) {
			imodel.next(DETAILED_PROJECT);
			return;
		}

		int projectID = imodel.getModelOptions().intSelectedProject;
		project = repository.getProjectById(projectID);
		projectComments = repository.getCommentsByProjectID(project.ID);
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
