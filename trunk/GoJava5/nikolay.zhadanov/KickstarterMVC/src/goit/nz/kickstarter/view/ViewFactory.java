package goit.nz.kickstarter.view;

import goit.nz.kickstarter.model.Model;

public class ViewFactory {

	public Displayable getView(Model model) {
		String viewType = model.getType();
		Displayable result;
		switch (viewType) {
		case "QUOTE":
			result = new QuoteView(model);
			break;
		case "CATEGORIES":
			result = new CategoriesView(model);
			break;
		case "PROJECTS":
			result = new ProjectsView(model);
			break;
		default:
			result = new EmptyView(model);
			break;
		}
		return result;
	}
}
