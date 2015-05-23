package kickstarter.pages.viewContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.Repository;

public class PageView {
	protected iModel imodel;

	protected Bank bank;
	protected ProjectComments projectComments;
	protected Project project;
	protected String[] strOptions;
	protected int[] intOptions;
	protected Repository repository;

	public void execute(String parameter) {
	}

	public String getHeader() {
		return null;
	}
}
