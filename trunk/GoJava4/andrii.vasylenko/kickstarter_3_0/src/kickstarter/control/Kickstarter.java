package kickstarter.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.model.dao.ConnectionPool;
import kickstarter.model.dao.ConnectionPoolImpl;
import kickstarter.model.dao.DAO;
import kickstarter.model.dao.DAOImpl;

@WebServlet("/")
public class Kickstarter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = getAction(request);
		if (action.startsWith("/categories")) {
			forwardCategories(request, response);
		} else if (action.startsWith("/projects")) {
			forwardProjects(request, response);
		} else if (action.startsWith("/project")) {
			forwardProject(request, response);
		} else {
			forwardQuotes(request, response);
		}
	}

	private void forwardProject(HttpServletRequest request, HttpServletResponse response) {
		try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
			DAO dao = new DAOImpl(connectionPool);

			int id = Integer.valueOf(request.getParameter("project"));
			int categoryId = Integer.valueOf(request.getParameter("category"));
			RequestDispatcher view = request.getRequestDispatcher("/Project.jsp");
			request.setAttribute("project", dao.getProject(id, categoryId));
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void forwardProjects(HttpServletRequest request, HttpServletResponse response) {
		try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
			DAO dao = new DAOImpl(connectionPool);

			int categoryId = Integer.valueOf(request.getParameter("category"));
			RequestDispatcher view = request.getRequestDispatcher("/Projects.jsp");
			request.setAttribute("projects", dao.getProjects(categoryId));
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void forwardCategories(HttpServletRequest request, HttpServletResponse response) {
		try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
			DAO dao = new DAOImpl(connectionPool);

			RequestDispatcher view = request.getRequestDispatcher("/Categories.jsp");
			request.setAttribute("categories", dao.getCategories());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void forwardQuotes(HttpServletRequest request, HttpServletResponse response) {
		try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
			DAO dao = new DAOImpl(connectionPool);

			RequestDispatcher view = request.getRequestDispatcher("/Quote.jsp");
			request.setAttribute("quote", dao.getRandomQuote());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getAction(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String action = requestURI.substring(request.getContextPath().length(), requestURI.length());
		return action;
	}
}
