package kickstarter.pages.modelContent;

import java.sql.SQLException;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.CurrentUserStatus;
import kickstarter.mvc.interfaces.IndexOfPage;

public class UserAccountModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		String[] array = message.split(":");
		if (array.length == 2) {
			try {
				CurrentUserStatus approved = idao.getUserService().verifyUser(
						array[0], array[1]);
				if (approved == null) {
					throw new ServiceException(
							"the user is not found in the service");
				}
			} catch (SQLException | ServiceException e) {
				imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.USER_ACCOUNT.ordinal());
			}
			return;
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.USER_ACCOUNT.ordinal());
	}

}
