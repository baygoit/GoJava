package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pool.KickstarterException;

public class Comment extends ViewDispatcher {

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		dispatchForward(request, response, "Comment.jsp",
				"Comment.jsp exception");

	}
}
