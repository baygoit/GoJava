package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeansStrategy;
import beans.eBeans;
import beans.iBean;
import dao.pool.KickstarterException;

public class ParentServlet extends HttpServlet {

	private static final long serialVersionUID = -2766866620374511233L;

	void dispatchDoGet(HttpServletRequest request,
			HttpServletResponse response, eBeans businessLogic)
			throws ServletException, IOException {
		iBean model = BeansStrategy.getInstance().getComponent(businessLogic);
		try {
			model.doGet(request, response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

	void dispatchDoPost(HttpServletRequest request,
			HttpServletResponse response, eBeans businessLogic)
			throws ServletException, IOException {
		iBean model = BeansStrategy.getInstance().getComponent(businessLogic);
		try {
			model.doPost(request, response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}
	
}
