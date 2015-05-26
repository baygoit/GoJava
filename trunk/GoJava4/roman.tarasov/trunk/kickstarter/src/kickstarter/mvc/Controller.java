package kickstarter.mvc;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.repository.facade.iRepository;

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

	public void updateStateOfModel(String message)  {
		imodel.updateStateOfModel(message);
	}

	public void setPage(int currentPage) {
		imodel.setPage(currentPage);
	}
	public void setRepository(iRepository setRepository) {
		imodel.setRepository(setRepository);
		iview.setRepository(setRepository);
	}

	public void setModel(iModel setModel) {
		iview.setModel(setModel);
		imodel.setModel(setModel);
	}
}
