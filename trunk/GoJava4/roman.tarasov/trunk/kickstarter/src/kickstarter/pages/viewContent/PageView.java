package kickstarter.pages.viewContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.Repository;

public abstract class PageView {
	protected iModel imodel;
	protected Bank bank;
	protected ProjectComments projectComments;
	protected Project project;
	protected String[] strOptions;
	protected int[] intOptions;
	protected Repository repository;
	protected ModelOptions modelOptions;

	public abstract String getHeader();

}
