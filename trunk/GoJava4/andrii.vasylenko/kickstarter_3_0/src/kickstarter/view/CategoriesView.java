package kickstarter.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriesView implements View {

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new HashMap<String, Object>();
	}

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response, Map<String, Object> data)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/Categories.jsp");
		request.setAttribute("categories", data.get("categories"));
		view.forward(request, response);
	}
}
