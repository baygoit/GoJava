package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.POM.dataModel.CostItem;
import ua.com.goit.gojava.POM.persistence.DataManager;
import ua.com.goit.gojava.POM.persistence.GenericDAO;

@WebServlet(urlPatterns = {"/webcontroller"})
public class WebController extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String param = req.getParameter("costItem");
		
		if (!param.isEmpty()) {
			DataManager dataManager = new DataManager();
			GenericDAO<CostItem> genericDAO = new GenericDAO<CostItem>(CostItem.class, dataManager);
			CostItem newCostItem = genericDAO.create();
			newCostItem.setName(param);
			
			dataManager.saveData();
		}
		
		resp.sendRedirect("index.jsp");
			
	}

	
}
