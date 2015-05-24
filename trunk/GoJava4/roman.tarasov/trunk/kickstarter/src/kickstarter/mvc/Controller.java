package kickstarter.mvc;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;

public class Controller {

	private iView iview;
	private iModel imodel;

	public Controller(iView iview, iModel imodel) {
		this.iview = iview;
		this.imodel = imodel;
	}

	public void showPage() {
		iview.showPage();
	}

	public void updateStateOfModel(String message) {
		imodel.updateStateOfModel(message);
	}

	public void setPage(int currentPage) {
		imodel.setPage(currentPage);
	}
}
