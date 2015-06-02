package kickstarter.pages.modelContent;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.pages.viewContent.PageView;

public abstract class PageModel {

	protected String[] strValues;
	protected int[] intValues;
	protected int intValue;
	protected String strValue;
	protected int pageId;
	protected int nextPage;
	protected ModelValues modelValues;
	protected  iModel imodel;
	protected  iView iview;
	protected PageView page;
	protected iDAO idao;

	public abstract void updateStateOfPageModel(String message)
			throws ServiceException;

	public void setIview(iView iview) {
		this.iview = iview;
	}

	public void setImodel(iModel imodel) {
		this.imodel = imodel;
	}
	public void setIDAO(iDAO idao) {
		this.idao = idao;
	}
}
