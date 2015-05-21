package kickstarter.pages.view;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.payment.Bank;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;

public class PageView {
	protected iModel imodel;
	protected ProjectRepository projects;
	protected CommentsRepository allComments;
	protected Bank bank;
	protected ProjectComments projectComments;
	protected Project project;
	protected  String[] strOptions;
	protected  int[] intOptions;
	

	public void execute(String parameter) {
	}


	public String getHeader() {
		return null;
	}
}
