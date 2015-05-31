package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.entity.ProjectComment;

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

			ProjectComment projectComment = new ProjectComment();
			projectComment.setProjectID(projectID);
			projectComment.setUserID(1);
			projectComment.setComment(array[1]);
			repository.addNewComment(projectComment);

			imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			return;
		}

		if (array[0].equals("d") && array.length == 2) {
			try {
				repository.deleteComment(projectID,
						(int) Integer.parseInt(array[1]));
				imodel.next(IndexOfPage.DETAILED_PROJECT.ordinal());
			} catch (NumberFormatException |RepositoryException e) {
			
				imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.COMMENT_PAGE.ordinal());
			}
			return;
		}

		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.COMMENT_PAGE.ordinal());
	}
}
