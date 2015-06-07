package kickstarter.pages.modelContent;

import java.sql.SQLException;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.CurrentUserStatus;
import kickstarter.mvc.interfaces.IndexOfPage;

public class UserAccountModel extends PageModel{

		@Override
		public void updateStateOfPageModel(String message) {
			if (message.equals("p")) {
				imodel.next(IndexOfPage.CATEGORIES.ordinal());
				return;
			}
			String[] array = message.split(":");
			if (array.length == 2) {
				try {
					CurrentUserStatus verifiedUser=idao.getUserService().verifyUser(array[0],array[1]);
					if(verifiedUser.getID()==0){
						verifiedUser=null;
						throw new ServiceException("user not found in default user service");
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
