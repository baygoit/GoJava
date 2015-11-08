package view;

import java.util.HashMap;

public class ViewStrategy {
	private volatile static ViewStrategy uniqueInstance;
	private static HashMap<eViews, ViewDispatcher> views;

	private ViewStrategy() {
	}

	public static ViewStrategy getInstance() {
		if (uniqueInstance == null) {
			synchronized (ViewStrategy.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ViewStrategy();
					views = new HashMap<eViews, ViewDispatcher>();

					views.put(eViews.CATEGORIES_V, new Categories());
					views.put(eViews.DETAILED_PROJECT_V,
							new DetailedProject());
					views.put(eViews.PROJECTS_V, new Projects());
					views.put(eViews.LOGIN_V, new Login());
					views.put(eViews.DONATE_V, new Donate());
					views.put(eViews.INVEST_V, new Invest());
					views.put(eViews.COMMENT_V, new Comment());
					views.put(eViews.COMMENT_FORM_V, new CommentForm());
				}
			}
		}
		return uniqueInstance;
	}

	public synchronized ViewDispatcher selectView(eViews selectedView) {
		return views.get(selectedView);
	}
}