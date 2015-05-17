package kickstarter.mvc;

import kickstarter.pages.Page;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;

public class Model implements iNavigator {
	private Storage<Page> pages;

	private String parameterForPrint;
	private int pageIndex;

	final int CATEGORIES = 0;
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	final int WRONG_CHOICE = 3;
	int intOption;
	String stringOption;

	Page page;

	public Model() {
		pages = new EntityStorage<Page>();

	}

	public void update(String command) {

		page = pages.getEntity(pageIndex);
		page.execute(command);
		page = pages.getEntity(pageIndex);
		page.parameterForPrint = intOption;
	}

	public void setPage(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public Page getPage() {
		return pages.getEntity(pageIndex);
	}

	public String getParameterForPrint() {
		return parameterForPrint;
	}

	public void add(Page page) {
		pages.add(page);

	}

	@Override
	public void pageWillBe(int nextPage) {
		pageIndex = nextPage;

	}

	@Override
	public void prevPage(int prevPage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOption(int intOption, String stringOption) {
		this.intOption = intOption;
		this.stringOption = stringOption;

	}
}
