package goit.nz.kickstarter;

import goit.nz.kickstarter.action.Action;
import goit.nz.kickstarter.action.ActionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MainServlet extends HttpServlet {
	private ActionFactory actionFactory;

	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		actionFactory = ctx.getBean("actionFactory", ActionFactory.class);
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Action action = actionFactory.getAction(request);
		String view = action.execute(request);
		if ("GET".equals(request.getMethod())) {
			request.getRequestDispatcher("/WEB-INF/pages/" + view + ".jsp").forward(
					request, response);
		} else {
			response.sendRedirect(view);
		}
	}

}