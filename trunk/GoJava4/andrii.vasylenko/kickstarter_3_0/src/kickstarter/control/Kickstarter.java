package kickstarter.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static kickstarter.control.State.*;
import kickstarter.model.Model;
import kickstarter.model.factory.ModelFactory;
import kickstarter.view.View;
import kickstarter.view.factory.ViewFactory;

@WebServlet("/")
public class Kickstarter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			State state = getState(request);
			View view = ViewFactory.getInstance().getView(state);
			Model model = ModelFactory.getInstance().getModel(state);

			Map<String, Object> parameters = view.getParameters(request, response);
			Map<String, Object> data = model.getData(parameters);

			view.forward(request, response, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private State getState(HttpServletRequest request) {
		String action = getAction(request);
		if (action.startsWith("/categories")) {
			return CATEGORIES;
		} else if (action.startsWith("/projects")) {
			return PROJECTS;
		} else if (action.startsWith("/project")) {
			return PROJECT;
		} else {
			return QUOTE;
		}
	}

	private String getAction(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String action = requestURI.substring(request.getContextPath().length(), requestURI.length());
		return action;
	}
}
