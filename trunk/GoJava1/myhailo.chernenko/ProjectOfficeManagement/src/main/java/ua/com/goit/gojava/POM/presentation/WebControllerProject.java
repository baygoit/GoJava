package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectType;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.ProjectService;

@WebServlet(urlPatterns = {"/ProjectWebController"})
public class WebControllerProject extends HttpServlet {

	private static final long serialVersionUID = -8469976402726558228L;
	private static final Logger LOG=Logger.getLogger(WebControllerProject.class);
	private static final String CLASS_NAME = "Project";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew") != null) {
			
			createProject(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deleteProject(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			loadProjectForEdit(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("Edit")!=null) {
			
			updateProject(req);
			resp.sendRedirect(req.getHeader("referer"));
				
		} else if (req.getParameter("UndoEdit")!=null) {
			
			req.getSession(false).setAttribute("currentProjectForEdit", null);
			resp.sendRedirect(req.getHeader("referer"));
		
		}
		

	}

	private void loadProjectForEdit(HttpServletRequest req) {
		
		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			Project project = projectService.retrieveById(id);
			req.getSession(false).setAttribute("currentProjectForEdit", project);
			
		} catch (NumberFormatException | POMServicesException e) {

			LOG.error("Can not load "+CLASS_NAME+" for edit: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not load "+CLASS_NAME+" for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteProject(HttpServletRequest req) {
		
		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			projectService.delete(projectService.retrieveById(id));
			
		} catch (NumberFormatException | POMServicesException e) {

			LOG.error("Can not delete "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete "+CLASS_NAME+": "+e.getMessage());
			return;	
		}
		
	}

	private void createProject(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String pmString = req.getParameter("pm");
		String descriptionString = req.getParameter("description");
		String activeString = req.getParameter("active");
		String typeString = req.getParameter("type");
		
		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
		Project project = new Project();
		
		try {
			
			project.setName(nameString);
			project.setPm(pmString);
			project.setDescription(descriptionString);
			project.setActive( (activeString == "on") ? true : false );
			if(!((typeString == null) || typeString.isEmpty())) {
				project.setType(ProjectType.valueOf(typeString));
			}
			
		} catch (IllegalArgumentException e)   {

			LOG.error("Could not create new "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not create new "+CLASS_NAME+": "+e.getMessage());
			return;
			
		}
		
		try {
			
			projectService.create(project);
			
		} catch (POMServicesException e) {

			LOG.error("Can not save new "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not save new "+CLASS_NAME+": "+e.getMessage());
			return;	
		}
	}
	
	private void updateProject(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String pmString = req.getParameter("pm");
		String descriptionString = req.getParameter("description");
		String activeString = req.getParameter("active");
		String typeString = req.getParameter("type");
		
		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
		Project project = (Project) req.getSession(false).getAttribute("currentProjectForEdit");
		
		try {
			
			project.setName(nameString);
			project.setPm(pmString);
			project.setDescription(descriptionString);
			project.setActive( (activeString.equals("on")) ? true : false );
			if(!((typeString == null) || typeString.isEmpty())) {
				project.setType(ProjectType.valueOf(typeString));
			}
			
			projectService.update(project);
			
		} catch (NumberFormatException | POMServicesException e)   {

			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not update "+CLASS_NAME+": "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentProjectForEdit", null);
		
	}
}
