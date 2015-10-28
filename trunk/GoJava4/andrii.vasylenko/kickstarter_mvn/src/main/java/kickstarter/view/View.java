package kickstarter.view;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public interface View {
	/**
	 * return Parameters from input data
	 */
	Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException;

	/**
	 * show web-page with data
	 */
	void forward(HttpServletRequest request, HttpServletResponse response, Map<String, Object> data)
			throws IncorrectInputException, ServletException, IOException;
}
