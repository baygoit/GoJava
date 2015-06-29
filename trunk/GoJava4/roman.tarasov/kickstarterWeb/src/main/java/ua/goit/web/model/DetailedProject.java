package ua.goit.web.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ua.goit.web.model.dao.Comment;
import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;


@Service
public class DetailedProject extends ModelService implements IConcreteService{
	public DetailedProject(IDao dao) {
		this.dao = dao;
		super.model = this;
	}

	private IDao dao;

	
	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException  {


		String parameter = request.getParameter("project");
		Integer projectIDfromParam = null;

		try {
			projectIDfromParam = Integer.valueOf(parameter);
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
		request.setAttribute("category",categoryID);
		Project project =dao.getProjectById(projectIDfromParam);
		request.setAttribute("detailedProject",project);
	
		List<Comment>comments = dao.getCommentsByProjectID(project.getID());
		request.setAttribute("comments", comments);

		List<String> listUsersNames = dao
				.getUsersNamesByListComments(comments);
		request.setAttribute("listUsersNames", listUsersNames);
	}

	@Override
	public String getJspName() {
		return "DetailedProject.jsp";
	}
}
