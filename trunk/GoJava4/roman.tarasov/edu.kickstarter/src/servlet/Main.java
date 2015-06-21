package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;
import static model.eModels.*;
import model.ModelStrategy;
import model.iModel;

/**
 * Servlet implementation class Main
 */

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		iModel model = ModelStrategy.getInstance().getModel(MAIN_M);
		try {
			model.doGet(request, response);
		} catch (KickstarterException e) {
		
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

}
