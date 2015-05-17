package kickstarter.mvc;



import kickstarter.pages.Page;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;

public class Model {
	private Storage<Page> pages;
	private Storage<ModelPage> modelPages;
	private String[] options;
	private String parameterForPrint;
	private int pageIndex;
	private int previousPageIndex;
	final int CATEGORIES = 0;
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	final int WRONG_CHOICE = 3;
	ModelPageInterface mpi;
	ModelPage modelPage;
	Page page;

	public Model() {
		pages = new EntityStorage<Page>();
		modelPages = new EntityStorage<ModelPage>();
	}
public void update (String command) {
	
	page = pages.getEntity(pageIndex);
	page.execute(command);
	int newpage=page.getNextPage();
	int parameter =page.parameterForPrint;

	pageIndex=newpage;
	page = pages.getEntity(pageIndex);
	page.parameterForPrint=parameter;

	
}
/*
	public void updates(String command) {
		modelPage = modelPages.getEntity(pageIndex);
		if (command == null) {
			return;
		}
		if (command.equals("e")) {
			pageIndex = modelPage.endPage;
			return;

		}
		if (command.equals("p")) {
			System.out.println("pppp");
			pageIndex = modelPage.previousPage;
			System.out.println(pageIndex);
			return;
		}
		options = modelPage.options;
		System.out.println(Arrays.toString(options) + " options");
		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (command.equals(options[index])) {

					pageIndex = modelPage.nextPage;
					modelPage = modelPages.getEntity(pageIndex);
					modelPage.parameter = options[index];
					parameterForPrint = new String(options[index]);
					return;
				}
			}
		}

		if (pageIndex == modelPage.errorPage) {
			return;
		}
		int tempMemory = pageIndex;
		pageIndex = modelPage.errorPage;
		modelPage = modelPages.getEntity(pageIndex);
		modelPage.previousPage = tempMemory;
	}
*/
	public void setOptions(String[] options) {
		modelPage = modelPages.getEntity(pageIndex);
		modelPage.setOptions(options);
	}

	public String getCommentOfOptions() {
		return modelPage.getCommentOfOptions();
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

	public void add(Page page, ModelPage modelPage) {
		pages.add(page);
		modelPages.add(modelPage);
	}
}
