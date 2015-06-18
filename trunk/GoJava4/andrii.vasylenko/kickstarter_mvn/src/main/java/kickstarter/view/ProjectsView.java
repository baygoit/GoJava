package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class ProjectsView extends AbstractJspView {

	private static final String JSP_NAME = "/Projects.jsp";
	private static final String[] INPUT_PARAMETERS = { "category" };
	private static final String[] OUTPUT_ATTRIBUTES = { "projects" };

	public ProjectsView() {
		super(JSP_NAME, OUTPUT_ATTRIBUTES);
	}

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException {
		return getIntegerParameters(request, response, INPUT_PARAMETERS);
	}
}
