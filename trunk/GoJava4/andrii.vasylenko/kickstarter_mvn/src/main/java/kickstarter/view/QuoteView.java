package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class QuoteView extends AbstractJspView {

	private static final String JSP_NAME = "/Quote.jsp";
	private static final String[] INPUT_PARAMETERS = {};
	private static final String[] OUTPUT_ATTRIBUTES = { "quote" };

	public QuoteView() {
		super(JSP_NAME, OUTPUT_ATTRIBUTES);
	}

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException {
		return getIntegerParameters(request, response, INPUT_PARAMETERS);
	}
}
