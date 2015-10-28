package ua.goit.web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import ua.goit.web.model.dao.Comment;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;

@Service
public class DetailedProject extends ModelService implements IConcreteService {
	public DetailedProject() {
		super.model = this;
	}

	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {

		setAttributesFromParameters(request);
		
		Project project = dao.getProjectById((Integer)request.getAttribute("project"));
		request.setAttribute("detailedProject", project);

		List<Comment> comments = dao.getCommentsByProjectID(project.getID());
		request.setAttribute("comments", comments);

		List<String> listUsersNames = dao.getUsersNamesByListComments(comments);
		request.setAttribute("listUsersNames", listUsersNames);
	}

	@Override
	public String getJspName() {
		return "DetailedProject.jsp";
	}

	@Override
	public void setAttributesForDoPost(HttpServletRequest request)
			throws KickstarterException {
	}
}
