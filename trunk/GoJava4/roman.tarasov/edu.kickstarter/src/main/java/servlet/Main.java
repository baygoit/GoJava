package servlet;

import static beans.eBeans.MAIN_M;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends ParentServlet {

	private static final long serialVersionUID = -8222738632721519597L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dispatchDoGet(request, response, MAIN_M);
	}
}
