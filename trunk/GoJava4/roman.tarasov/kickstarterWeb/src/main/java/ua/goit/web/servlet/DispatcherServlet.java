package ua.goit.web.servlet;

import java.io.IOException;
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
import ua.goit.web.model.dao.KickstarterException;

@Controller
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	ModelServiceLocator modelServiceLocator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
				config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelService model = getModel(request);
		try {
			if(model==null){
				throw new KickstarterException("Model not found");
			}
			model.doGet(request, response);
		} catch (KickstarterException e) {
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelService model = getModel(request);
		try {
			if(model==null){
				throw new KickstarterException("Model not found");
			}
			model.doPost(request, response);
		} catch (KickstarterException e) {
		}
	}

	private ModelService getModel(HttpServletRequest request) {
		String path = dispatch(request);
		if (path.equals("/")) {
			path = "/main";
		}
		String cleanPath = path.substring(1, path.length());
		Set<String> keySet = modelServiceLocator.getKeys();
		ModelService model =null;
		for (String selectPath : keySet) {
			if (cleanPath.startsWith(selectPath)) {
				model = (ModelService) modelServiceLocator
						.getService(selectPath);
				break;
			}
		}
		return model;
	}

	private String dispatch(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return requestURI.substring(request.getContextPath().length(),
				requestURI.length());
	}
}
