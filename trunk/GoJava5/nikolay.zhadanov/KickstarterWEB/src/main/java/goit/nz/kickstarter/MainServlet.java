package goit.nz.kickstarter;

import goit.nz.kickstarter.action.Action;
import goit.nz.kickstarter.action.ActionFactory;
import goit.nz.kickstarter.storage.DataStorage;
import goit.nz.kickstarter.storage.PostgreStorage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final String DB_PROPS_FILE = "db.properties";
	private ActionFactory actionFactory;
	private DataStorage dataStorage;

	@Override
	public void init() throws ServletException {
		super.init();
		actionFactory = new ActionFactory();
		PostgreStorage dbStorage = new PostgreStorage();
		dbStorage.init(DB_PROPS_FILE);
		dataStorage = dbStorage;
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Action action = actionFactory.getAction(request);
		String view = action.execute(request, response, dataStorage);
		//if ("GET".equals(request.getMethod())) {
			request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(
					request, response);
		/*} else if ("POST".equals(request.getMethod())) {
			response.sendRedirect(view);
		}*/

	}

}