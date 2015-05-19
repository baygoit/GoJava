package kickstarter.mvc;

import kickstarter.pages.Page;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.iStorage;

public class Model implements iNavigator {
	private iStorage<Page> pages;

	private String sParameterForPage;
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
		page.parameterForPage = intOption;
		page.stringParameterForPage=stringOption;
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
		return sParameterForPage;
	}

	public void add(Page page) {
		pages.add(page);
	}

	@Override
	public void pageWillBe(int pageIndex) {
		this.pageIndex = pageIndex;
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
