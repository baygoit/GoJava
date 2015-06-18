package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class ProjectView extends AbstractJspView {

	private static final String JSP_NAME = "/Project.jsp";
	private static final String[] INPUT_PARAMETERS = { "project", "category" };
	private static final String[] OUTPUT_ATTRIBUTES = { "project" };

	public ProjectView() {
		super(JSP_NAME, OUTPUT_ATTRIBUTES);
	}

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException {
		return getIntegerParameters(request, response, INPUT_PARAMETERS);
	}
}
