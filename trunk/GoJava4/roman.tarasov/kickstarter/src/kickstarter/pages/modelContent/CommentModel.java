package kickstarter.pages.modelContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;

public class CommentModel extends PageModel {
	ProjectComments projectComments;
	@Override
	public void updateStateOfPageModel(String message)
			throws RepositoryException {
		if (message.equals("p")) {
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}

		Project project = repository
				.getProjectById(imodel.getModelValues().intSelectedProject);
		projectComments = repository.getCommentsByProjectID(project.ID);
		String[] array = message.split(":");
		if (array[0].equals("a") && array.length == 2) {
			if (projectComments != null) {
				// TODO
				projectComments.addComment(1, array[1]);// 1- user ID
			} else {
				repository.addNewComment(1,
						imodel.getModelValues().intSelectedProject, array[1]);
			}
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		if (array[0].equals("d") && array.length == 3) {
			try {
				projectComments.deleteComment(array[1], array[2]);
			} catch (NumberFormatException | NullPointerException e) {
				imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.COMMENT_PAGE.ordinal());
				return;
			}
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.COMMENT_PAGE.ordinal());
	}
}
