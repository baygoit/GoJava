package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.database.contract.CategoryDao;
import ua.com.goit.gojava7.kickstarter.database.contract.FaqDao;
import ua.com.goit.gojava7.kickstarter.database.contract.PaymentDao;
import ua.com.goit.gojava7.kickstarter.database.contract.ProjectDao;
import ua.com.goit.gojava7.kickstarter.database.contract.RewardDao;


@Controller
public class ProjectController {
	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private FaqDao faqDao;
	@Autowired
	private RewardDao rewardDao;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	@Transactional
	public ModelAndView project(@RequestParam(name = "id") int projectId) {
		ModelAndView modelAndView = new ModelAndView("project");

		List<Category> categories = categoryDao.getAll();
		log.info("All categories: " + categories);

		Project project = projectDao.getProjectById(projectId);
		log.info("Selected project: " + project);

		project.setCollectedSum(paymentDao.getSumProjectPayments(project.getId()));
		log.info("Project after added pledges: " + project);

		List<Faq> questions = faqDao.getProjectFaqs(projectId);
		log.info("All questions: " + questions);

		List<Reward> rewards = rewardDao.getProjectsRewards(projectId);
		log.info("All rewards: " + rewards);

		modelAndView.addObject("categories", categories);
		modelAndView.addObject("project", project);
		modelAndView.addObject("rewards", rewards);
		modelAndView.addObject("questions", questions);

		return modelAndView;
	}
}
