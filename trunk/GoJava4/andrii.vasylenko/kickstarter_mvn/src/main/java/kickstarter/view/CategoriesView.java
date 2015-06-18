package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class CategoriesView extends AbstractJspView {

	private static final String JSP_NAME = "/Categories.jsp";
	private static final String[] INPUT_PARAMETERS = {};
	private static final String[] OUTPUT_ATTRIBUTES = { "categories" };

	public CategoriesView() {
		super(JSP_NAME, OUTPUT_ATTRIBUTES);
	}

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException {
		return getIntegerParameters(request, response, INPUT_PARAMETERS);
	}
}
