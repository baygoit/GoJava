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

	public void update(String message) {
		imodel.update(message);
	}

	public void setPage(int pageIndex) {
		imodel.setPage(pageIndex);
	}
}
