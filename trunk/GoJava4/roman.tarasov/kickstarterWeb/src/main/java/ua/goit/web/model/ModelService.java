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
}
