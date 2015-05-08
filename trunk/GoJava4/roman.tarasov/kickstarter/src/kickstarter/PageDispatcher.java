package kickstarter;

public class PageDispatcher {
	UserInterface ui;
	CategoryList categories;
	ProjectList projects;
	Page page;
	
	PageDispatcher(UserInterface ui, CategoryList categories,
			ProjectList projects) {

		this.ui = ui;
		this.categories = categories;
		this.projects = projects;
	}

	void cycleDispatcher() {
		while (true) {
			page = page.getNextPage();
		}
	}

	public void startDispatcher() {
		Page[] pages = new Page[5];
		Page adminCategoriesControl = new PageAdminCategoriesControl(categories);
		Page loginPage = new PageLogin();
		
		Page userCategoriesView = new PageUserCategoriesView(categories, projects);
		userCategoriesView.setPages(pages);
		userCategoriesView.setUI(ui);

		Page userProjectsView = new PageUserProjectsView(projects);
		userProjectsView.setPages(pages);
		userProjectsView.setUI(ui);
		
		Page detailedProjectInfo =new DetailedProjectInfo(projects);
		detailedProjectInfo.setPages(pages);
		detailedProjectInfo.setUI(ui);
	
		pages[0] = loginPage;
		pages[1] = adminCategoriesControl;
		pages[2] = userCategoriesView;
		pages[3] = userProjectsView;
		pages[4] = detailedProjectInfo;

		adminCategoriesControl.setPages(pages);
		adminCategoriesControl.setUI(ui);

		loginPage.setPages(pages);
		loginPage.setNextPage(loginPage);
		loginPage.setUI(ui);
		page = loginPage;

		cycleDispatcher();
	}

}
