package goit.nz.kickstarter.action;

import goit.nz.kickstarter.model.CategoryModel;
import goit.nz.kickstarter.storage.DataStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryAction implements Action {
	private CategoryModel model;
	private final String VIEW = "category";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, DataStorage storage) {
		long categoryId = Long.parseLong(request.getParameter("id"));
		model = new CategoryModel(storage);
		model.update(categoryId);
		request.setAttribute("model", model);
		return VIEW;
	}

}
