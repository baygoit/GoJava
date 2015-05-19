package kickstarter.mvc;

import kickstarter.pages.Page;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.iStorage;

public class Model implements iNavigator {
	private iStorage<Page> pages;

	private int pageIndex;

	int iOption;
	int selectedCategory;
	int selectedProject;
	String sOption;

	Page page;

	private int savePage;

	public Model() {
		pages = new EntityStorage<Page>();
	}

	public void update(String command) {
		page = pages.getEntity(pageIndex);
		page.execute(command);
		page = pages.getEntity(pageIndex);
		page.iOption = iOption;
		page.sOption = sOption;
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

	public void add(Page page) {
		pages.add(page);
	}

	@Override
	public void next(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public void setOption(int intOption, String stringOption) {
		this.iOption = intOption;
		this.sOption = stringOption;
	}

	@Override
	public void saveCategory(int selectedCategory) {
		this.selectedCategory = selectedCategory;
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

	@Override
	public void goToAndBack(int toPage, int back) {
		this.savePage = back;
		this.pageIndex = toPage;

	}

	@Override
	public void nextWithOptions(int page, int iOption, String sOption) {
		this.pageIndex = page;
		this.iOption = iOption;
		this.sOption = sOption;

	}
}
