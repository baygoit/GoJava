package kickstarter.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public abstract class AbstractJspView implements View {

	private String jspName;
	private String[] outputAttributes;

	public AbstractJspView(String jspName, String[] outputAttributes) {
		this.jspName = jspName;
		this.outputAttributes = outputAttributes;
	}

	protected Map<String, Object> getIntegerParameters(HttpServletRequest request, HttpServletResponse response,
			String[] inputParameters) throws IncorrectInputException {
		checkInput(request, response);

		Map<String, Object> result = new HashMap<String, Object>();

		for (String parameter : inputParameters) {
			result.put(parameter, Integer.valueOf(request.getParameter(parameter)));
		}

		return result;
	}

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response, Map<String, Object> data)
			throws IncorrectInputException, ServletException, IOException {
		checkInput(request, response);

		RequestDispatcher view = request.getRequestDispatcher(jspName);

		for (String attribute : outputAttributes) {
			request.setAttribute(attribute, data.get(attribute));
		}

		view.forward(request, response);
	}

	private void checkInput(HttpServletRequest request, HttpServletResponse response) throws IncorrectInputException {
		if (request == null || response == null) {
			throw new IncorrectInputException("request or response is null");
		}
	}
}
