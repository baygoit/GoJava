package ua.goit.web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;


@Service
public class Projects extends ModelService implements IConcreteService {
	public Projects(IDao dao) {
		this.dao = dao;
		super.model = this;
	}

	private IDao dao;


	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {

		List<Project> sortedProjects = null;
		Integer categoryID = null;
		String parameterFromURL = request.getParameter("category");
		try {
			categoryID = Integer.valueOf(parameterFromURL);
		} catch (NumberFormatException e) {
			throw new KickstarterException("illegal number of category");
		}
		sortedProjects = dao.sortProjectsByCategoryID(categoryID);
		request.setAttribute("category", categoryID);
		request.setAttribute("sortedProjects", sortedProjects);
	}

	@Override
	public String getJspName() {
		return "Projects.jsp";
	}
}