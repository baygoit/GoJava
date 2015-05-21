package kickstarter.mvc;

import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;



public class Controller implements iController{

	private iView iview;
	private iModel imodel;

	public Controller(iView iview, iModel imodel) {
		this.iview = iview;
		this.imodel = imodel;
	}

	public void printView() {
		iview.print();
	}

	public void update(String command) {
		imodel.update(command);
	}

	public void setPage(int pageIndex) {
		imodel.setPage(pageIndex);
	}


}
