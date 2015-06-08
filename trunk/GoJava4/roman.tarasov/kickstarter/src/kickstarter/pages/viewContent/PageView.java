package kickstarter.pages.viewContent;

import java.sql.SQLException;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;

public abstract class PageView {
	protected iModel imodel;
	protected iView iview;
	protected String[] strValues;
	protected int[] intValues;
	protected ModelValues modelValues;
	protected iDAO idao;

	public abstract String getHeader() throws ServiceException, SQLException;

	public void setImodel(iModel imodel) {
		this.imodel = imodel;
	}

	public void setIview(iView iview) {
		this.iview = iview;
	}

	public void setIDAO(iDAO idao) {
		this.idao = idao;
	}
}
