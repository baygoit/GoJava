package ua.nenya.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public String bindQuestion(@PathVariable Long projectId, Map<String, Object> model){
		
		if (!projectDao.isProjectExist(projectId)) {
			model.put("projectId", projectId);
			model.put("projectTestId", -1);
			return "404";
		}
		
		Project project = projectDao.getProjectByProjectId(projectId);
		model.put("project", project);
		
		model.put("questionForm", new Question());
		
		return "question";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addQuestion(@Valid @ModelAttribute("questionForm") Question question,
			BindingResult result, Map<String, Object> model) {
		
		Long projectId = question.getProject().getId();
		
		if (result.hasErrors()) {
			model.put("project", projectDao.getProjectByProjectId(projectId));
			return "question";
		}

		Question savedQuestion = questionDao.writeQuestionInProject(question);
		if (savedQuestion != null) {
			return "redirect:/project/"+projectId;
		} else {
			model.put("question", question.getName());
			return "400";
		}
	}

}
