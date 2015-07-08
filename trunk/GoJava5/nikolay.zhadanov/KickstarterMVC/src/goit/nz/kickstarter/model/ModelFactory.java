package goit.nz.kickstarter.model;

import goit.nz.kickstarter.DataStorage;
import goit.nz.kickstarter.dao.CategoryList;
import goit.nz.kickstarter.dao.ProjectList;
import goit.nz.kickstarter.dao.QuoteList;

public class ModelFactory {

	public Model getModel(DataStorage storage, String modelType, int selection) {
		Model result;
		switch (modelType) {
		case "QUOTE":
			QuoteList quotes = storage.getQuotes();
			result = new QuoteModel(modelType, quotes, "Quote");
			break;
		case "CATEGORIES":
			CategoryList categories = storage.getCategories();
			result = new CategoryModel(modelType, categories, "Category List: ");
			break;
		case "PROJECTS":
			ProjectList projects = storage.getProjects(selection - 1);
			result = new ProjectsModel(modelType, projects,
					"Projects in category \""
							+ projects.getCategory().getName() + "\"");
			break;
		default:
			result = new EmptyModel("EMPTY!", "Empty model...");
			break;
		}
		return result;
	}
}
