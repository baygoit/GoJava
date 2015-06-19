package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MainImpl;
import model.Model;
import dao.category.Category;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.quote.Quote;

/**
 * Servlet implementation class Main
 */

public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Model mainModel = new MainImpl();
		
		try {
			@SuppressWarnings("unchecked")
			List<Category> categories = (List<Category>) mainModel
					.getAttribute("categories");
			Quote quote = (Quote) mainModel.getAttribute("quote");
			request.setAttribute("categories", categories);
			request.setAttribute("quote", quote);
			request.getRequestDispatcher("Main.jsp").forward(request, response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

	@Override
	public void init() throws ServletException {
	}

	@Override
	public void destroy() {
		super.destroy();
		try {
			Pool.getInstance().getConnection().close();
		} catch (SQLException | KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(),
				requestURI.length());
		return action;
	}
}