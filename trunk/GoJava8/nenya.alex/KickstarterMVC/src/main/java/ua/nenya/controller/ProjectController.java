package ua.nenya.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;

@Controller
public class ProjectController {
	@Autowired
	private QuoteDao quoteDao;

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public String showProject(@PathVariable Long projectId, Map<String, Object> model){
		if (!projectDao.isProjectExist(projectId)) {
			logger.error("Project with id "+projectId+" dosen't exist!");
			model.put("projectId", projectId);
			model.put("projectTestId", -1);
			return "404Page";
		}
		
		Project project = projectDao.getProjectByProjectId(projectId);
		model.put("category", project.getCategory());
		model.put("project", project);
		model.put("quote", quoteDao.getRandomQuote());

		List<Question> questions = questionDao.getQuestions(projectId);
		model.put("questions", questions);
		model.put("questionForm", new Question());
		return "projectPage";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView handleTypeMismatchException(HttpServletRequest request, TypeMismatchException ex) {
		logger.error("Requested URL="+request.getRequestURL());
        logger.error("Exception Raised="+ex);
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
         
        modelAndView.setViewName("errorPage");
        return modelAndView;
	}

}
