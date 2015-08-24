package goit.nz.kickstarter.action;

import goit.nz.kickstarter.model.MainPageModel;
import goit.nz.kickstarter.storage.DataStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPageAction implements Action {
	private MainPageModel model;
	private final String VIEW = "main";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, DataStorage storage) {
		model = new MainPageModel(storage);
		model.update();
		request.setAttribute("model", model);
		return VIEW;
	}

}
