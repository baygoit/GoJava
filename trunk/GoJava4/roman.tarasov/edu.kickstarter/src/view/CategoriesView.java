package view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriesView implements iView {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CategoriesView(HttpServletRequest request,
			HttpServletResponse response) {

		this.request = request;
		this.response = response;
	}

	@Override
	public void setAttribute(String attribute, Object parameter) {
		request.setAttribute(attribute, parameter);
	}

	@Override
	public void forward() {
		try {
			request.getRequestDispatcher("Main.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
