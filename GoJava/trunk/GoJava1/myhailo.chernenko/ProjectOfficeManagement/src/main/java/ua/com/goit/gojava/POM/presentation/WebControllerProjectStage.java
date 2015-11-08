package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.ProjectService;
import ua.com.goit.gojava.POM.services.ProjectStageService;

@WebServlet(urlPatterns = {"/ProjectStageWebController"})
public class WebControllerProjectStage extends HttpServlet {

	private static final long serialVersionUID = 1714188275429310709L;
	private static final Logger LOG=Logger.getLogger(WebControllerProjectStage.class);
	private static final String CLASS_NAME = "Project Stage";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew") != null) {
			
			createProjectStage(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deleteProjectStage(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			loadProjectStageForEdit(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("Edit")!=null) {
			
			updateProjectStage(req);
			resp.sendRedirect(req.getHeader("referer"));
				
		} else if (req.getParameter("UndoEdit")!=null) {
			
			req.getSession(false).setAttribute("currentProjectStageForEdit", null);
			resp.sendRedirect(req.getHeader("referer"));
		
		}
		

	}

	private void loadProjectStageForEdit(HttpServletRequest req) {
		
		ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			ProjectStage projectStage = projectStageService.retrieveById(id);
			req.getSession(false).setAttribute("currentProjectStageForEdit", projectStage);
			
		} catch (NumberFormatException | POMServicesException e) {

			LOG.error("Can not load "+CLASS_NAME+" for edit: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not load "+CLASS_NAME+" for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteProjectStage(HttpServletRequest req) {
		
		ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			projectStageService.delete(projectStageService.retrieveById(id));
			
		} catch (NumberFormatException | POMServicesException e) {

			LOG.error("Can not delete "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete "+CLASS_NAME+": "+e.getMessage());
			return;	
		}
		
	}

	private void createProjectStage(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String parentId = req.getParameter("parent");
		String descriptionString = req.getParameter("description");
		
		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
		ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
		ProjectStage projectStage = new ProjectStage();
		
		try {
			
			projectStage.setName(nameString);
			projectStage.setDescription(descriptionString);
			if(!((parentId == null) || parentId.isEmpty())) {
				projectStage.setParent(projectService.retrieveById(Long.parseLong(parentId)));
			}
			
		} catch (IllegalArgumentException | POMServicesException e)   {

			LOG.error("Could not create new "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not create new "+CLASS_NAME+": "+e.getMessage());
			return;
			
		}
		
		try {
			
			projectStageService.create(projectStage);
			
		} catch (POMServicesException e) {

			LOG.error("Can not save new "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not save new "+CLASS_NAME+": "+e.getMessage());
			return;	
		}
	}
	
	private void updateProjectStage(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String parentId = req.getParameter("parent");
		String descriptionString = req.getParameter("description");
		
		ProjectService projectService = (ProjectService) ApplicationContextProvider.getApplicationContext().getBean("ProjectService");
		ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
		ProjectStage projectStage = (ProjectStage) req.getSession(false).getAttribute("currentProjectStageForEdit");
		
		try {
			
			projectStage.setName(nameString);
			projectStage.setDescription(descriptionString);
			if(!((parentId == null) || parentId.isEmpty())) {
				projectStage.setParent(projectService.retrieveById(Long.parseLong(parentId)));
			}
			
			projectStageService.update(projectStage);
			
		} catch (NumberFormatException | POMServicesException e)   {

			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not update "+CLASS_NAME+": "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentProjectStageForEdit", null);
		
	}
}
