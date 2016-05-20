package ua.nenya.controller;

import java.util.List;
import java.util.Map;

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

@RequestMapping(value = "/category/project")
@Controller
public class ProjectController {

	@Autowired
	protected ProjectDao projectDao;
	
	@Autowired
	protected QuestionDao questionDao;
	
	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public String showProject(@PathVariable Long projectId, Map<String, Object> model){
		if (!projectDao.isProjectExist(projectId)) {
			model.put("projectId", projectId);
			return "404";
		}
		
		Project project = projectDao.getProjectByProjectId(projectId);
		model.put("category", project.getCategory());
		model.put("project", project);

		List<Question> questions = questionDao.getQuestions(projectId);
		model.put("questions", questions);
		model.put("questionForm", new Question());
		return "project";
	}
	
	@RequestMapping(value = "/{projectId}/add", method = RequestMethod.POST)
	public String addQuestion(@PathVariable Long projectId, @ModelAttribute("questionForm") Question question,
			BindingResult result, Map<String, Object> model) {
		if (result.hasErrors()) {
			model.put("project", question.getProject());
			return "question";
		}

		Question savedQuestion = questionDao.writeQuestionInProject(question);
		if (savedQuestion != null) {
			return "redirect:/category/project/"+projectId;
		} else {
			model.put("question", question.getName());
			return "400";
		}
	}
}
