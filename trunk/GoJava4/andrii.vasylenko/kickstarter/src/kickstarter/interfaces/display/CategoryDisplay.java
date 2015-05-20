package kickstarter.interfaces.display;

import kickstarter.engine.Category;

public class CategoryDisplay implements Display<Category> {
	@Override
	public String getDescription(Category category) {
		if (category == null) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		result.append(category.getId());
		result.append(" - ");
		result.append(category.getName());
		result.append("\r\n");
		return result.toString();
	}
}
