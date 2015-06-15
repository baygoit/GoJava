package kickstarter.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.view.View;

public class QuoteView implements View {

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response) {
		return new HashMap<String, Object>();
	}

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response, Map<String, Object> data)
			throws Exception {
		RequestDispatcher view = request.getRequestDispatcher("/Quote.jsp");
		request.setAttribute("quote", data.get("quote"));
		view.forward(request, response);
	}

}
