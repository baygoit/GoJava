package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pool.KickstarterException;

public class Login extends ViewDispatcher {

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		try {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (Exception e) {
			throw new KickstarterException("Login.jsp exception", e);
		}
	}

}