package ua.com.goit.gojava7.kickstarter.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RequestValidation {

	public boolean isEmpty(HttpServletRequest request, List<String> parameters) {
		String recvestParam;
		for (String parameter : parameters) {
			recvestParam = request.getParameter(parameter);
			if (recvestParam == null) {
				request.setAttribute("errors", true);
				return true;
			}
			if (recvestParam.isEmpty()) {
				request.setAttribute("errors", true);
				return true;
			}
		}
		return false;
	}

	public boolean isNatural(HttpServletRequest request, List<String> parameters) {
		String recvestParam;
		for (String parameter : parameters) {
			recvestParam = request.getParameter(parameter);
			if (recvestParam == null) {
				request.setAttribute("errors", true);
				return true;
			}
			try {
				int i = Integer.parseInt(recvestParam);
				if (i <= 0) {
					request.setAttribute("errors", true);
					return true;
				}
			} catch (NumberFormatException nfe) {
				request.setAttribute("errors", true);
				return true;
			}
		}
		return false;
	}
}
