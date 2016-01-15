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
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.handlers.FunctionsInsideProject;
import ua.com.goit.gojava7.kickstarter.servlets.MainServlet;

@Controller
public class ControllerServlet {
	private static final Logger log = LoggerFactory.getLogger(MainServlet.class);
	@Autowired
	private QuoteDao quoteDao;
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
	@Autowired
	private FunctionsInsideProject functionsInsideProject;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");

		Quote randomQuote = quoteDao.getRandomQuote();
		log.info("Random quote: {}", randomQuote);

		List<Category> categories = categoryDao.getAll();
		log.info("All categories: {}", categories);

		modelAndView.addObject("quote", randomQuote);
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}

	@RequestMapping(value = "/category")
	@Transactional
	public ModelAndView category(@RequestParam(name = "id") int categoryId) {
		ModelAndView modelAndView = new ModelAndView("category");

		List<Category> categories = categoryDao.getAll();
		log.info("All categories: " + categories);

		List<Project> projects = projectDao.getProjectsFromCategory(categoryId);
		log.info("All projects: " + projects);

		for (Project project : projects) {
			project.setCollectedSum(paymentDao.getSumProjectPayments(project.getId()));
		}
		log.info("All projects after added pledges: " + projects);

		modelAndView.addObject("categories", categories);
		modelAndView.addObject("projects", projects);
		return modelAndView;
	}

	@RequestMapping(value = "/project")
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
		functionsInsideProject.saveCreatedFaq(projectDao, faqDao, projectId, question);
		log.info("Added new question");

		return "redirect:./project?id=" + projectId;
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@Transactional
	public String addPayment(@RequestParam(name = "projectId") int projectId, @RequestParam(name = "userName") String userName,
			@RequestParam(name = "creditCardNumber") long creditCardNumber, @RequestParam(name = "pledge") int pledge) {

		functionsInsideProject.savePayment(projectDao, paymentDao, projectId, userName, creditCardNumber, pledge);
		log.info("Added new payment");

		return "redirect:./project?id=" + projectId;
	}

	@RequestMapping(value = "/top10", method = RequestMethod.GET)
	@Transactional
	public ModelAndView showTop10Categories() {
		ModelAndView modelAndView = new ModelAndView("top10categories");

		List<Object[]> top10Categories = categoryDao.getTop10Categories();
		log.info("Top 10 categories: {}", top10Categories);

		List<Category> categories = categoryDao.getAll();
		log.info("All categories: " + categories);

		modelAndView.addObject("top10Categories", top10Categories);
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}
}
