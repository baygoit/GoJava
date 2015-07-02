package ua.goit.web.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;

@Service
public class ModelService {
	protected IConcreteService model;
	protected IDao dao;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
	
		model.setAttributesForDoGet(request);
		forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
	
		model.setAttributesForDoPost(request);
		forward(request, response);

	}

	private void forward(HttpServletRequest request,
			HttpServletResponse response) throws KickstarterException {
		String jspName = model.getJspName();
		try {
			request.getRequestDispatcher(jspName).forward(request, response);
		} catch (ServletException | IOException e) {
			throw new KickstarterException(jspName + " has error", e);
		}
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	void setAttributesFromParameters(HttpServletRequest request) throws KickstarterException {
		String parameter = request.getParameter("project");
		Integer projectID = null;
		try {
			projectID = Integer.valueOf(parameter);
		} catch (NumberFormatException e) {
			throw new KickstarterException("illegal number of project ");
		}
		Integer categoryID = null;
		String parameterFromURL = request.getParameter("category");
		try {
			categoryID = Integer.valueOf(parameterFromURL);
		} catch (NumberFormatException e) {
			throw new KickstarterException("illegal number of category");
		}
		Integer investOption = null;
		String parameterInvestOption = request.getParameter("option");
		try {
			investOption = Integer.valueOf(parameterInvestOption);
		} catch (NumberFormatException e) {
			
		}
		request.setAttribute("option", investOption);
		request.setAttribute("category", categoryID);
		request.setAttribute("project", projectID);
	}
}
