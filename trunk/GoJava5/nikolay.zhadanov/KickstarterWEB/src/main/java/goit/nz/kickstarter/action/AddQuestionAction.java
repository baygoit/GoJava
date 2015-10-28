package goit.nz.kickstarter.action;

import goit.nz.kickstarter.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "**/project", params = "question", method = RequestMethod.POST)
public class AddQuestionAction {
	private String view;
	private ProjectService projectService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value = "{projectId}/addQuestion", method = RequestMethod.POST)
	public String execute(@RequestParam("question") String question,
			@RequestParam("redirect") String redirect,
			@PathVariable("projectId") long projectId) {
		projectService.addQuestion(projectId, question);
		view = modifyRedirectLink(redirect);
		return view;
	}

	private String modifyRedirectLink(String redirect) {
		int last = redirect.lastIndexOf('/');
		int first = redirect.indexOf('/', 1);
		String result = "redirect:" + redirect.substring(first, last + 1)
				+ "view";
		return result;
	}

}
