package goit.nz.kickstarter.action;

import goit.nz.kickstarter.domain.Project;
import goit.nz.kickstarter.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "**/project", method = RequestMethod.GET)
public class ProjectAction {
	private static final String VIEW = "project";
	private ProjectService projectService;
	private ModelAndView model;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value = "{projectId}/{action}", method = RequestMethod.GET)
	public ModelAndView execute(@PathVariable("projectId") long projectId,
			@PathVariable("action") String actionType) {
		if ("view".equals(actionType)) {
			model = new ModelAndView();
			Project project = projectService.getProject(projectId);
			model.addObject("project", project);
			model.addObject("events", project.getEvents());
			model.addObject("faqs", project.getFaq());
			model.addObject("rewards", project.getRewardOptions());
			model.addObject("category", project.getCategory());
			model.addObject("isQuestion", false);
			model.addObject("isDonate", false);
			model.setViewName(VIEW);
		}
		if ("question".equals(actionType)) {
			model.addObject("isQuestion", true);
		}
		if ("donate".equals(actionType)) {
			model.addObject("isDonate", true);
		}
		return model;
	}

}
