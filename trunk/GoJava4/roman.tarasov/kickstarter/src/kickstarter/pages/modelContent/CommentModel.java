package kickstarter.pages.modelContent;

import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;

public class CommentModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message)
			throws RepositoryException {
		if (message.equals("p")) {
			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}
		int projectID = imodel.getModelValues().getIntSelectedProject();

		String[] array = message.split(":");
		if (array[0].equals("a") && array.length == 2) {

			ProjectComments projectComments = new ProjectComments(projectID, 1,
					array[1]);
			repository.addNewComment(projectComments);

			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}

		if (array[0].equals("d") && array.length == 2) {
			try {
				repository.deleteComment(projectID,
						(int) Integer.parseInt(array[1]));
			} catch (RepositoryException e) {
			
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
