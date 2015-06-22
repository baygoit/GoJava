package view;

import view.eViews;

public class ViewStrategy {
	private volatile static ViewStrategy uniqueInstance;
	private static CategoriesView categoriesView;
	private static DetailedProjectView detailedProjectView;
	private static ProjectsView projectsView;
	private static LoginView loginView;

	private ViewStrategy() {
	}

	public static ViewStrategy getInstance() {
		if (uniqueInstance == null) {
			synchronized (ViewStrategy.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ViewStrategy();
					categoriesView = new CategoriesView();
					detailedProjectView = new DetailedProjectView();
					projectsView = new ProjectsView();
					loginView = new LoginView();
				}
			}
		}
		return uniqueInstance;
	}

	public iView selectView(eViews selectedView) {
		iView iview = null;
		switch (selectedView) {

		case CATEGORIES_V:
			iview = categoriesView;
			break;
		case DETAILED_PROJECT_V:
			iview = detailedProjectView;
			break;
		case PROJECTS_V:
			iview = projectsView;
			break;
		case LOGIN_V:
			iview = loginView;
			break;
		default:
			break;
		}
		return iview;
	}
}