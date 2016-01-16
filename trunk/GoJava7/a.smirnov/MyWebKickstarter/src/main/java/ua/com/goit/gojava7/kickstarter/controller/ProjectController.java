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
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

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

	@RequestMapping(value = "/ask", method = RequestMethod.POST)
	@Transactional
	public String addQuestion(@RequestParam(name = "projectId") int projectId, @RequestParam(name = "question") String question) {
		Project project = projectDao.getProjectById(projectId);
		log.info("Question will be added to project: {}", project);

		Faq faq = new Faq();
		faq.setProject(project);
		faq.setQuestion(question);

		faqDao.add(faq);
		log.info("Added new question");

		return "redirect:./project?id=" + projectId;
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@Transactional
	public String addPayment(@RequestParam(name = "projectId") int projectId, @RequestParam(name = "userName") String userName,
			@RequestParam(name = "creditCardNumber") long creditCardNumber, @RequestParam(name = "pledge") int pledge) {

		Project project = projectDao.getProjectById(projectId);
		log.info("Payment will be added to project: {}", project);

		Payment payment = new Payment();
		payment.setProject(project);
		payment.setOwnerName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setPledge(pledge);

		paymentDao.add(payment);
		log.info("Added new payment");

		return "redirect:./project?id=" + projectId;
	}
}
