package beans;

import static view.eViews.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import view.ViewDispatcher;
import view.ViewStrategy;
import dao.pool.KickstarterException;

public class Comment implements iBean {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		ViewDispatcher selectedView = ViewStrategy.getInstance().selectView(
				COMMENT_V);
		selectedView.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
	}
}
