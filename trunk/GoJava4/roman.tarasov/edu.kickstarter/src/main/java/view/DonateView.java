package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;

public class DonateView implements iView {

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		try {
			request.getRequestDispatcher("Donate.jsp").forward(request,
					response);
		} catch (Exception e) {
			throw new KickstarterException("Donate.jsp exception", e);
		}
	}
}
