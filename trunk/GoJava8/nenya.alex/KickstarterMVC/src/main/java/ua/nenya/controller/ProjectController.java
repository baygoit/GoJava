package ua.nenya.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;

@Controller
public class ProjectController {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public String showProject(@PathVariable Long projectId, Map<String, Object> model){
		if (!projectDao.isProjectExist(projectId)) {
			model.put("projectId", projectId);
			model.put("projectTestId", -1);
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

}
