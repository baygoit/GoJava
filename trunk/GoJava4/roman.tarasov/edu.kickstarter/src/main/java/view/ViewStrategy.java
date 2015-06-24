package view;

import java.util.HashMap;

public class ViewStrategy {
	private volatile static ViewStrategy uniqueInstance;
	private static HashMap<eViews, iView> views;

	private ViewStrategy() {
	}

	public static ViewStrategy getInstance() {
		if (uniqueInstance == null) {
			synchronized (ViewStrategy.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ViewStrategy();
					views = new HashMap<eViews, iView>();

					views.put(eViews.CATEGORIES_V, new CategoriesView());
					views.put(eViews.DETAILED_PROJECT_V,
							new DetailedProjectView());
					views.put(eViews.PROJECTS_V, new ProjectsView());
					views.put(eViews.LOGIN_V, new LoginView());
					views.put(eViews.DONATE_V, new DonateView());
					views.put(eViews.INVEST_V, new InvestView());
					views.put(eViews.COMMENT_V, new CommentView());
					views.put(eViews.COMMENT_FORM_V, new CommentFormView());
				}
			}
		}
		return uniqueInstance;
	}

	public synchronized iView selectView(eViews selectedView) {
		return views.get(selectedView);
	}
}