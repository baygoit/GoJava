package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pool.KickstarterException;

public class Donate extends ViewDispatcher {

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		dispatchForward(request, response, "Donate.jsp", "Donate.jsp exception");
	}
}
