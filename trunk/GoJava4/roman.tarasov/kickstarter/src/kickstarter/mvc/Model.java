package kickstarter.mvc;

import kickstarter.pages.Page;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;

public class Model implements iNavigator {
	private Storage<Page> pages;

	private String parameterForPrint;
	private int pageIndex;

	int intOption;
	int selectedCategory;
	int selectedProject;
	String stringOption;

	Page page;

	private int savePage;

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

	@Override
	public void saveCategory(int selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	@Override
	public void saveProject(int selectedProject) {
		this.selectedProject = selectedProject;
	}

	@Override
	public int getSavedCategory() {
		return selectedCategory;
	}

	@Override
	public void savePageBeforeError(int savePage) {
		this.savePage = savePage;
	}

	@Override
	public int getSavedPage() {
		return savePage;
	}
}
