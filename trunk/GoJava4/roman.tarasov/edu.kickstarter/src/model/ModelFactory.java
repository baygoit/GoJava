package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;

public class ModelFactory {
	private iModel selectedModel;

	public ModelFactory(eModels model, HttpServletRequest request,
			HttpServletResponse response) {
		switch (model) {
		case MAIN:
			selectedModel = new NewMainModel(request, response);
			break;
		default:
			break;
		}
	}

	public void execute() throws KickstarterException {
		selectedModel.execute();
	}
}
