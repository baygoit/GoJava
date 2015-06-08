package kickstarter.pages.modelContent;

import java.sql.SQLException;

import kickstarter.mvc.interfaces.iController;

public class TheEndModel extends PageModel {

	private iController icontroller;

	public TheEndModel(iController icontroller) {
		this.icontroller=icontroller;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		try {
			icontroller.getDatabaseService().closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
}
