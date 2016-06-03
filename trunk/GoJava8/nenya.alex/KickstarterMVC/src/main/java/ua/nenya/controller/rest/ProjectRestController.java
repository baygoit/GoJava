package ua.nenya.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import ua.nenya.controller.jsp.CategoryController;
import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;

@RestController
@RequestMapping("/rest")
public class ProjectRestController {
	
	@Autowired
	private ProjectDao projectDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@RequestMapping(value = "/project/", method = RequestMethod.GET)
	public List<Project> getProjects() {
		return projectDao.getProjects();
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public Project getProject(@PathVariable("projectId") Long projectId) {
		if (!projectDao.isProjectExistById(projectId)) {
			logger.error("Project with id "+projectId+" dosen't exist!");
			return new Project();
		}
		return projectDao.getProjectByProjectId(projectId);
	}
	
	@RequestMapping(value = "/project/{projectId}/delete", method = RequestMethod.DELETE)
	public String deleteProject(@PathVariable("projectId") Long projectId) {
		if (!projectDao.isProjectExistById(projectId)) {
			logger.error("Project with id "+projectId+" dosen't exist!");
			return "failure";
		}
		Project project = projectDao.deleteProjectByProjectId(projectId);
		return "Project \""+project.getName() + "\" is deleted successfully";
	}
	
	@RequestMapping(value = "/project/add/{projectJson}", method = RequestMethod.POST)
	public String addProject(@PathVariable("projectJson") String projectJson) {
		ObjectMapper mapper = new ObjectMapper();
		Project project = null;
		try {
			project = mapper.readValue(projectJson, Project.class);
		} catch (IOException e) {
			logger.error("projectJson mapping error");
			logger.trace("Exception: ", e);
		}
		
		if(!projectDao.isProjectExistByName(project.getName())){
			if(!projectDao.isProjectExistById(project.getId())){
				Project savedProject = projectDao.saveProject(project);
				logger.info("Saving success!");
				return "Project \""+savedProject.getName() + "\" with id = "+savedProject.getId()+" is saved successfully";
			}else{
				logger.info("Saving failure!");
				return "failure";
			}
		}else{
			logger.info("Saving failure!");
			return "failure";
		}
	}
	
	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
	public String addProject(Project project) {
		
		if(!projectDao.isProjectExistByName(project.getName())){
			if(!projectDao.isProjectExistById(project.getId())){
				Project savedProject = projectDao.saveProject(project);
				logger.info("Saving success!");
				return "Project \""+savedProject.getName() + "\" with id = "+savedProject.getId()+" is saved successfully";
			}else{
				logger.info("Saving failure!");
				return "failure";
			}
		}else{
			logger.info("Saving failure!");
			return "failure";
		}
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleTypeMismatchException(HttpServletRequest request, TypeMismatchException ex) {
        return "failure TypeMismatchException";
	}

}
