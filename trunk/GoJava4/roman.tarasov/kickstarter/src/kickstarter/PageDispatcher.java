package kickstarter;

public class PageDispatcher {
	Page adminCategoriesControl;
	Page loginPage;
	Page userCategoriesView;
	Page userProjectsView;

	UserInterface ui;

	CategoryList categories;
	ProjectList projects;

	Page page;
	Page[] pages = new Page[4];

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

		adminCategoriesControl = new PageAdminCategoriesControl(categories);
		loginPage = new PageLogin();
		userCategoriesView = new PageUserCategoriesView(categories, projects);
		userCategoriesView.setPages(pages);
		userCategoriesView.setUI(ui);

		userProjectsView = new PageUserProjectsView(projects);
		userProjectsView.setPages(pages);
		userProjectsView.setUI(ui);

		pages[0] = loginPage;
		pages[1] = adminCategoriesControl;
		pages[2] = userCategoriesView;
		pages[3] = userProjectsView;

		adminCategoriesControl.setPages(pages);
		adminCategoriesControl.setUI(ui);

		loginPage.setPages(pages);
		loginPage.setNextPage(loginPage);
		loginPage.setUI(ui);
		page = loginPage;

		cycleDispatcher();
	}

}
