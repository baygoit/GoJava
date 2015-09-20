package ua.goit.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.goit.web.model.ModelService;
import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.database.DDao;
import ua.goit.web.model.dao.database.Pool;
import ua.goit.web.model.dao.memory.MDao;

@Controller
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDao dao;
	@Autowired
	private ModelServiceLocator modelServiceLocator;
	@Autowired
	private MDao memoryDao;
	@Autowired
	private DDao databaseDao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
				config.getServletContext());
		if (connected()) {
			dao = databaseDao;
		} else {
			dao = memoryDao;
		}
	}

	private boolean connected() {
		boolean connected = false;
		try {
			Connection conn = Pool.getDataSource().getConnection();
			conn.close();
			connected = true;
		} catch (SQLException e) {
		}
		return connected;
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelService concreteModel = getModel(request);
		try {
			if (concreteModel == null) {
				throw new KickstarterException("Model not found");
			}
			concreteModel.doGet(request, response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelService concreteModel = getModel(request);
		try {
			if (concreteModel == null) {
				throw new KickstarterException("Model not found");
			}
			concreteModel.doPost(request, response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

	private ModelService getModel(HttpServletRequest request) {
		String path = trimPath(request);
		if (path.equals("/")) {
			path = "/main";
		}
		String cleanPath = path.substring(1, path.length());
		Set<String> keySet = modelServiceLocator.getKeys();
		ModelService model = null;
		for (String selectPath : keySet) {
			if (cleanPath.startsWith(selectPath)) {
				model = (ModelService) modelServiceLocator
						.getService(selectPath);
				model.setDao(dao);
				break;
			}
		}
		return model;
	}

	private String trimPath(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return requestURI.substring(request.getContextPath().length(),
				requestURI.length());
	}
}
