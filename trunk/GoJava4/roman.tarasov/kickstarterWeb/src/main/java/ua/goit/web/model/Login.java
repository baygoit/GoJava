package ua.goit.web.model;

import javax.servlet.http.HttpServletRequest;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.User;

public class Login extends ModelService implements IConcreteService {
	public Login() {
		super.model = this;
	}

	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {
		setAttributesFromParameters(request);
	}

	@Override
	public void setAttributesForDoPost(HttpServletRequest request)
			throws KickstarterException {
		setAttributesFromParameters(request);
		User modelOfUser = new User();
		User user = null;

		modelOfUser.setLogin(request.getParameter("login"));
		modelOfUser.setPassword(request.getParameter("pwd"));

		try {
			user = dao.getUserInfo(modelOfUser.getLogin(),
					modelOfUser.getPassword());
			request.getSession().setAttribute("userName", user.getName());
			request.getSession().setAttribute("user", user);
		} catch (KickstarterException e) {
			request.getSession().setAttribute("userName", null);
			request.getSession().setAttribute("user", null);
		}
	}

	@Override
	public String getJspName() {
		return "Login.jsp";
	}
}
