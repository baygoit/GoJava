package goit.nz.kickstarter.action;

import goit.nz.kickstarter.domain.Project;
import goit.nz.kickstarter.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DonateAction {
	private String VIEW = "donate";
	private ProjectService projectService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value = "**/project/{projectId}/donate/thankyou", params = "chosenAmount", method = RequestMethod.POST)
	public ModelAndView doPayment(@PathVariable("projectId") long projectId,
			@RequestParam("chosenAmount") int chosenAmount) {
		projectService.pledgeAmount(projectId, chosenAmount);
		Project project = projectService.getProject(projectId);
		ModelAndView model = new ModelAndView();
		model.addObject("project", project);
		model.addObject("confirmed", true);
		model.setViewName(VIEW);
		return model;
	}

	@RequestMapping(value = "**/project/{projectId}/donate/{rewardId}", method = RequestMethod.GET)
	public ModelAndView showPayment(@PathVariable("projectId") long projectId,
			@PathVariable("rewardId") long rewardId) {
		Project project = projectService.getProject(projectId);
		ModelAndView model = new ModelAndView();
		model.addObject("project", project);
		model.addObject("confirmed", false);
		if (rewardId > 0) {
			int chosenAmount = projectService.getRewardAmount(projectId,
					rewardId);
			model.addObject("chosenAmount", chosenAmount);
		}
		model.setViewName(VIEW);
		return model;
	}

}
