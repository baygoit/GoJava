package ua.goit.web.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import ua.goit.web.model.dao.Comment;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;
import ua.goit.web.model.dao.User;

@Service
public class CommentPage extends ModelService implements IConcreteService {
	public CommentPage() {
		super.model = this;
	}

	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {
		setAttributesFromParameters(request);
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
		
		setAttributesFromParameters(request);
		Project project = dao.getProjectById((Integer)request.getAttribute("project"));

		User user = (User) session.getAttribute("user");
		Comment comment = new Comment();
		comment.setProjectID(project.getID());
		comment.setUserID(user.getID());
		comment.setComment(request.getParameter("commentForm"));
		dao.addComment(comment);
	}
}