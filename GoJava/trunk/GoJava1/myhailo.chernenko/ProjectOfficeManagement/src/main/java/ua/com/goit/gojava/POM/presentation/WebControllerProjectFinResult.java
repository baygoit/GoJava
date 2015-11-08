package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProfitLostsType;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.ProjectFinResultEntryService;
import ua.com.goit.gojava.POM.services.ProjectService;
import ua.com.goit.gojava.POM.services.ProjectStageService;

@WebServlet(urlPatterns = {"/ProjectFinResultWebController"})
public class WebControllerProjectFinResult extends HttpServlet {

	private static final long serialVersionUID = 2330324352739910889L;
	private static final Logger LOG=Logger.getLogger(WebControllerProjectFinResult.class);
	private static final String CLASS_NAME = "Project FinResult Entry";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew") != null) {
			
			createProjectFinResultEntry(req);
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deleteProjectFinResultEntry(req);
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			loadProjectFinResultEntryForEdit(req);
		
		} else if (req.getParameter("Edit")!=null) {
			
			updateProjectFinResultEntry(req);
			
		} else if (req.getParameter("UndoEdit")!=null) {
			
			req.getSession(false).setAttribute("currentEntryForEdit", null);
		
		}
		
		resp.sendRedirect(req.getHeader("referer"));
		
	}

	private void loadProjectFinResultEntryForEdit(HttpServletRequest req) {
		
		ProjectFinResultEntryService projectFinResultEntryService = ApplicationContextProvider.getApplicationContext().getBean(ProjectFinResultEntryService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			ProjectFinResultEntry projectFinResultEntry = projectFinResultEntryService.retrieveById(id);
			req.getSession(false).setAttribute("currentEntryForEdit", projectFinResultEntry);
			
		} catch (POMServicesException | NumberFormatException e) {

			LOG.error("Can not load "+CLASS_NAME+" for edit: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not load "+CLASS_NAME+" for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteProjectFinResultEntry(HttpServletRequest req) {
		
		ProjectFinResultEntryService projectFinResultEntryService = ApplicationContextProvider.getApplicationContext().getBean(ProjectFinResultEntryService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			projectFinResultEntryService.delete(projectFinResultEntryService.retrieveById(id));
			
		} catch (POMServicesException | NumberFormatException e) {

			LOG.error("Can not delete "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete "+CLASS_NAME+": "+e.getMessage());
			return;	
		}
		
	}

	private void createProjectFinResultEntry(HttpServletRequest req) {
		
		String dateString = req.getParameter("date");
		String costItemId = req.getParameter("costItem");
		String projectId = req.getParameter("project");
		String projectStageId = req.getParameter("projectStage");
		String typeString = req.getParameter("type");
		String currencyString = req.getParameter("currency");
		String sumString = req.getParameter("sum");
		
		ProjectFinResultEntry newEntry = new ProjectFinResultEntry();
		
		try {
			
			String pattern = (dateString.length() == 10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
			newEntry.setDate(dateFormatter.parse(dateString));
			
			CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
			if(!((costItemId == null) || costItemId.isEmpty())) {
				CostItem costItemRef = costItemService.retrieveById(Long.parseLong(costItemId));
				newEntry.setCostItem(costItemRef);
			}
			ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
			if(!((projectId == null) || projectId.isEmpty())) {
				Project projectRef = projectService.retrieveById(Long.parseLong(projectId));
				newEntry.setProject(projectRef);
			}
			ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
			if(!((projectStageId == null) || projectStageId.isEmpty())) {
				ProjectStage projectStageRef = projectStageService.retrieveById(Long.parseLong(projectStageId));
				newEntry.setProjectStage(projectStageRef);
			}
			if(!((typeString == null) || typeString.isEmpty())) {
				newEntry.setType(ProfitLostsType.valueOf(typeString));
			}
			
			Currency currency = Currency.getInstance(currencyString);
			Money sum = new Money(Double.parseDouble(sumString),currency);
			newEntry.setSum(sum) ;		
			
		} catch (ParseException | IllegalArgumentException | POMDataModelException | POMServicesException e)   {

			LOG.error("Could not create new "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not create new "+CLASS_NAME+": "+e.getMessage());
			return;
			
		}
		
		ProjectFinResultEntryService projectFinResultEntryService = ApplicationContextProvider.getApplicationContext().getBean(ProjectFinResultEntryService.class);
		try {
			
			projectFinResultEntryService.create(newEntry);
			
		} catch (POMServicesException e) {

			LOG.error("Can not save new "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not save new "+CLASS_NAME+": "+e.getMessage());
			return;	
		}
	}
	
	private void updateProjectFinResultEntry(HttpServletRequest req) {
		
		String dateString = req.getParameter("date");
		String costItemId = req.getParameter("costItem");
		String projectId = req.getParameter("project");
		String projectStageId = req.getParameter("projectStage");
		String typeString = req.getParameter("type");
		String currencyString = req.getParameter("currency");
		String sumString = req.getParameter("sum");
		
		ProjectFinResultEntry projectFinResultEntry = (ProjectFinResultEntry) req.getSession(false).getAttribute("currentEntryForEdit");
		
		try {
			
			String pattern = (dateString.length() == 10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
			projectFinResultEntry.setDate(dateFormatter.parse(dateString));
			
			CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
			if(!((costItemId == null) || costItemId.isEmpty())) {
				CostItem costItemRef = costItemService.retrieveById(Long.parseLong(costItemId));
				projectFinResultEntry.setCostItem(costItemRef);
			}
			ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
			if(!((projectId == null) || projectId.isEmpty())) {
				Project projectRef = projectService.retrieveById(Long.parseLong(projectId));
				projectFinResultEntry.setProject(projectRef);
			}
			ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
			if(!((projectStageId == null) || projectStageId.isEmpty())) {
				ProjectStage projectStageRef = projectStageService.retrieveById(Long.parseLong(projectStageId));
				projectFinResultEntry.setProjectStage(projectStageRef);
			}
			if(!((typeString == null) || typeString.isEmpty())) {
				projectFinResultEntry.setType(ProfitLostsType.valueOf(typeString));
			}
			
			Currency currency = Currency.getInstance(currencyString);
			Money sum = new Money(Double.parseDouble(sumString),currency);
			projectFinResultEntry.setSum(sum) ;
			
			ProjectFinResultEntryService projectFinResultEntryService = ApplicationContextProvider.getApplicationContext().getBean(ProjectFinResultEntryService.class);
			projectFinResultEntryService.update(projectFinResultEntry);
			
		} catch (POMDataModelException | ParseException | NumberFormatException | POMServicesException e)   {

			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not update "+CLASS_NAME+": "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentEntryForEdit", null);
		
	}

}
