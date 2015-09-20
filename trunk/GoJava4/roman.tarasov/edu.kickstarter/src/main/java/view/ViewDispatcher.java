package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;

public abstract class ViewDispatcher {
	abstract public void forward(HttpServletRequest request,
			HttpServletResponse response) throws KickstarterException;

	public void dispatchForward(HttpServletRequest request,
			HttpServletResponse response, String jsp, String errorMessage)
			throws KickstarterException {
		try {
			request.getRequestDispatcher(jsp).forward(request, response);
		} catch (Exception e) {
			throw new KickstarterException(errorMessage, e);
		}
	}
}
