package ua.goit.web.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import ua.goit.web.model.dao.Comment;
import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;
import ua.goit.web.model.dao.User;

@Service
public class CommentPage extends ModelService implements IConcreteService {
	public CommentPage(IDao dao) {
		this.dao = dao;
		super.model = this;
	}
	private IDao dao;
	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {
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
		request.setAttribute("category", categoryID);
		request.setAttribute("project", projectID);
	}

	@Override
	public String getJspName() {
		return "Comment.jsp";
	}

	@Override
	public void setAttributesForDoPost(HttpServletRequest request)
			throws KickstarterException {
		
	HttpSession session = request.getSession();
	if (session.getAttribute("user") == null) {
		throw new KickstarterException(
				"comments allowed only for registered user");
	}

	Comment comment = new Comment();
	String parameter = request.getParameter("project");
	Integer projectIDfromParam = null;
	Project project =null;
	try {
		projectIDfromParam = Integer.valueOf(parameter);
		project = dao.getProjectById(projectIDfromParam);
		
	} catch (Exception e) {
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
	request.setAttribute("project", projectIDfromParam);
	
	User user = (User) session.getAttribute("user");
	comment.setProjectID(project.getID());
	comment.setUserID(user.getID());
	comment.setComment(request.getParameter("commentForm"));
	dao.addComment(comment);
	}
}