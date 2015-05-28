package kickstarter.pages.viewContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public abstract class PageView {
	public iModel imodel;
	public iView iview;
	protected Bank bank;
	protected ProjectComments projectComments;
	protected Project project;
	protected String[] strOptions;
	protected int[] intOptions;
	public iRepository repository;
	protected ModelOptions modelOptions;

	public abstract String getHeader() throws RepositoryException ;

}
