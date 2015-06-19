package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewFactory {

	private iView selectedView;

	public ViewFactory(eViews views, HttpServletRequest request,
			HttpServletResponse response) {

		switch (views) {
		case CATEGORIES:
			selectedView = new CategoriesView(request, response);
			break;
		default:
			break;
		}
	}

	public void setAttribute(String attribute, Object parameter) {
		selectedView.setAttribute(attribute, parameter);
	}

	public void forward() {
		selectedView.forward();
	}
}
