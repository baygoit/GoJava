package servlet;

import static model.eModels.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelStrategy;
import model.iModel;
import dao.pool.KickstarterException;


public class CommentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		iModel model = ModelStrategy.getInstance().getModel(COMMENT_FORM_M);

		try {
			model.doPost(request, response);
		} catch (KickstarterException e) {

			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

}
