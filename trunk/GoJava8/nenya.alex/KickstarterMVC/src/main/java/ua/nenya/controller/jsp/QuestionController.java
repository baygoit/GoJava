package ua.nenya.controller.jsp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import ua.nenya.validator.QuestionValidator;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
	
	@Autowired
	private QuoteDao quoteDao;
	
	@Autowired
	private QuestionValidator questionValidator;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public String bindQuestion(@PathVariable Long projectId, Map<String, Object> model){
		
		if (!projectDao.isProjectExistById(projectId)) {
			logger.error("Project with id "+projectId+" dosen't exist!");
			model.put("projectId", projectId);
			model.put("projectTestId", -1);
			return "404Page";
		}
		
		Project project = projectDao.getProjectByProjectId(projectId);
		model.put("project", project);
		model.put("quote", quoteDao.getRandomQuote());
		
		model.put("questionBind", new Question());
		
		return "questionPage";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addQuestion(@Valid @ModelAttribute("questionBind") Question question,
			BindingResult result, Map<String, Object> model) {
		
		questionValidator.validate(question, result);
		
		Long projectId = question.getProject().getId();
		
		if (result.hasErrors()) {
			logger.error("Result "+result+" has errors!" );
			
			model.put("project", projectDao.getProjectByProjectId(projectId));
			model.put("quote", quoteDao.getRandomQuote());
			return "questionPage";
		}

		questionDao.writeQuestionInProject(question);
		
		return "redirect:/project/"+projectId;
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
