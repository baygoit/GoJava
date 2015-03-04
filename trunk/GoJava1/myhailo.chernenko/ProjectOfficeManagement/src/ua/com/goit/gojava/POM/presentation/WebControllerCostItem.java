package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.persistence.fileDB.DAOFactory;
import ua.com.goit.gojava.POM.persistence.fileDB.DataManager;
import ua.com.goit.gojava.POM.persistence.fileDB.GenericDAO;

@WebServlet(urlPatterns = {"/CostItemWebController"})
public class WebControllerCostItem extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String param = req.getParameter("costItem");
		
		if (!param.isEmpty()) {
			DAOFactory dataManager = new DataManager();
			GenericDAO<CostItem> genericDAO = new GenericDAO<CostItem>(CostItem.class, dataManager);
			CostItem newCostItem = genericDAO.create();
			newCostItem.setName(param);
			
			dataManager.saveData();
		}
		
		resp.sendRedirect(req.getHeader("referer"));
			
	}

	
}
