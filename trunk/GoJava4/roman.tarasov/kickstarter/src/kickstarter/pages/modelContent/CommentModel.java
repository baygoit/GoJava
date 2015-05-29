package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.entity.ProjectComment;

public class CommentModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message)
			throws RepositoryException {
		if (message.equals("p")) {
			getImodel().next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		int projectID = getImodel().getModelValues().getIntSelectedProject();

		String[] array = message.split(":");
		if (array[0].equals("a") && array.length == 2) {

			ProjectComment projectComment = new ProjectComment(projectID, 1,
					array[1]);
			getRepository().addNewComment(projectComment);

			getImodel().next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}

		if (array[0].equals("d") && array.length == 2) {
			try {
				getRepository().deleteComment(projectID,
						(int) Integer.parseInt(array[1]));
			} catch (NumberFormatException |RepositoryException e) {
			
				getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.COMMENT_PAGE.ordinal());
				return;
			}
			getImodel().next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}

		getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.COMMENT_PAGE.ordinal());
	}
}
