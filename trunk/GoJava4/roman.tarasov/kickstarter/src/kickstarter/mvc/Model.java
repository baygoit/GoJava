package kickstarter.mvc;

import java.util.Arrays;

import kickstarter.pages.PageView;
import kickstarter.pages.model.PageModel;
import kickstarter.pages.model.ModelOptions;
import kickstarter.pages.model.ViewOptions;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.iStorage;

public class Model implements iModel {
	final int CATEGORIES = 0;
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	final int ERROR_PAGE = 3;
	final int END_PAGE = 4;
	final int COMMENT_PAGE = 5;
	final int INVEST_PAGE = 6;
	final int DONATE_PAGE = 7;
	final int BANK_OPERATION_RESULT_PAGE = 8;
	final int APPLY_TRANSACTION_PAGE = 9;
	public String[] strOptions;
	public int[] intOptions;
	public int intOption;
	public String strOption;
	public int selectedCategory;
	public int selectedProject;
	public int pageId;
	public String name;
	int nextPage;

	private int pageIndex;
	ModelOptions options;
	private iStorage<PageView> pages;
	private iStorage<PageModel> modelPages;

	PageModel pageModel;
	private int savePage;
	private ViewOptions viewOptions;

	public Model() {
		pages = new EntityStorage<PageView>();
		modelPages = new EntityStorage<PageModel>();
	}

	public void update(String command) {
		pageModel = modelPages.getEntity(pageIndex);
		pageModel.execute(command);
		pageModel = modelPages.getEntity(pageIndex);
	}

	public void setOptions(ModelOptions setO) {
		this.options = setO;
	}

	public void setPage(int setPage) {
		this.pageIndex = setPage;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public PageView getPage() {
		return pages.getEntity(pageIndex);
	}

	public void next(int nextPage) {
		this.pageIndex = nextPage;
	}

	public void setOption(int intOption, String stringOption) {
		this.intOption = intOption;
		this.strOption = stringOption;
	}

	public int getSavedCategory() {
		return selectedCategory;
	}

	public void savePageBeforeError(int saved) {
		this.savePage = saved;
	}

	public int getSavedPage() {
		return savePage;
	}

	public void goToAndBack(int toPage, int back) {
		this.savePage = back;
		this.pageIndex = toPage;
	}

	public void saveCategory(int sc) {
		this.selectedCategory = sc;
	}

	public ModelOptions getOptions() {
		return options;
	}

	public void add(PageView pv, PageModel pm) {
		pages.add(pv);
		modelPages.add(pm);
	}

	@Override
	public void nextWithOptions(int next, ModelOptions o) {
		this.pageIndex = next;
		this.options = o;

	}

	@Override
	public void setViewOptions(ViewOptions vo) {
		this.viewOptions = vo;

	}


}
