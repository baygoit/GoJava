package ua.goit.web.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.goit.web.model.dao.KickstarterException;

public class ModelService {
	IConcreteService model;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		model.setAttributesForDoGet(request);

		String jspName=model.getJspName();
		try {
			request.getRequestDispatcher(jspName).forward(request, response);
		} catch (ServletException | IOException e) {
			throw new KickstarterException(jspName + " has error", e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
	}
}
