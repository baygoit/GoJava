package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProfitLostsType;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.POMServicesException;

@WebServlet(urlPatterns = {"/CostItemWebController"})
public class WebControllerCostItem extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;
	private static final Logger LOG=Logger.getLogger(WebControllerCostItem.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew") != null) {
			
			createCostItem(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deleteCostItem(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			loadCostItemForEdit(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("Edit")!=null) {
			
			updateCostItem(req);
			resp.sendRedirect(req.getHeader("referer"));
				
		} else if (req.getParameter("UndoEdit")!=null) {
			
			req.getSession(false).setAttribute("currentCostItemForEdit", null);
			resp.sendRedirect(req.getHeader("referer"));
		
		}
		

	}

	private void loadCostItemForEdit(HttpServletRequest req) {
		
		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			CostItem costItem = costItemService.retrieveById(id);
			req.getSession(false).setAttribute("currentCostItemForEdit", costItem);
			
		} catch (NumberFormatException | POMServicesException e) {

			LOG.error("Can not load Cost Item for edit: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not load Cost Item for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteCostItem(HttpServletRequest req) {
		
		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			costItemService.delete(costItemService.retrieveById(id));
			
		} catch (NumberFormatException | POMServicesException e) {

			LOG.error("Can not delete Cost Item: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete Cost Item: "+e.getMessage());
			return;	
		}
		
	}

	private void createCostItem(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String typeString = req.getParameter("type");
		String parentId = req.getParameter("parentId");
		
		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		CostItem costItem = new CostItem();
		
		try {
			
			costItem.setName(nameString);
			if(!((typeString == null) || typeString.isEmpty())) {
				costItem.setType(ProfitLostsType.valueOf(typeString));
			}
			if(!((parentId == null) || parentId.isEmpty())) {
				costItem.setParent(costItemService.retrieveById(Long.parseLong(parentId)));
			}
			
		} catch (IllegalArgumentException | POMServicesException e)   {

			LOG.error("Could not create new Cost Item: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not create new Cost Item: "+e.getMessage());
			return;
			
		}
		
		try {
			
			costItemService.create(costItem);
			
		} catch (POMServicesException e) {

			LOG.error("Can not save new Cost Item: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not save new Cost Item: "+e.getMessage());
			return;	
		}
	}
	
	private void updateCostItem(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String typeString = req.getParameter("type");
		String parentId = req.getParameter("parentId");
		
		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		CostItem costItem = (CostItem) req.getSession(false).getAttribute("currentCostItemForEdit");
		
		try {
			
			costItem.setName(nameString);
			if(!((typeString == null) || typeString.isEmpty())) {
				costItem.setType(ProfitLostsType.valueOf(typeString));
			} else {
				costItem.setType(null);
			}
			
			if(!((parentId == null) || parentId.isEmpty())) {
				costItem.setParent(costItemService.retrieveById(Long.parseLong(parentId)));
			} else {
				costItem.setParent(null);
			}
			
			costItemService.update(costItem);
			
		} catch (NumberFormatException | POMServicesException e)   {

			LOG.error("Could not update Cost Item: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not update Cost Item: "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentCostItemForEdit", null);
		
	}
}
