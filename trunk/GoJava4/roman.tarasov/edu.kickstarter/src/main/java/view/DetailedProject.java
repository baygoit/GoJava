package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pool.KickstarterException;

public class DetailedProject extends ViewDispatcher {

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		try {
			request.getRequestDispatcher("DetailedProject.jsp").forward(
					request, response);
		} catch (Exception e) {
			throw new KickstarterException("DetailedProject.jsp exception", e);
		}

	}

}
