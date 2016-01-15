package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Controller
public class CategoriesController {
	private static final Logger log = LoggerFactory.getLogger(CategoriesController.class);

	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private RewardDao rewardDao;
	@Autowired
	private PaymentDao paymentDao;
	
	@RequestMapping("/categories")
	public ModelAndView categories() {
		ModelAndView modelAndView = new ModelAndView("categories");

		Quote quote = quoteDao.getRandomQuote();
		modelAndView.addObject("quote", quote);
		log.debug("Random quote: {}", quote);

		List<Category> categories = categoryDao.getCategories();
		modelAndView.addObject("categories", categories);
		log.debug("Categories: {}", categories);

		return modelAndView;
	}

	@RequestMapping("/projects")
	public ModelAndView projects(@RequestParam(name = "id") int categoryId) {
		ModelAndView modelAndView = new ModelAndView("projects");

		modelAndView.addObject("categoryId", categoryId);
		log.debug("categoryId: {}", categoryId);

		List<Project> projects = projectDao.getProjects(categoryId);
		modelAndView.addObject("projects", projects);
		log.debug("Projects: {}", projects);

		return modelAndView;
	}

	@RequestMapping("/project")
	public ModelAndView project(@RequestParam(name = "projectId") int projectId) {
		ModelAndView modelAndView = new ModelAndView("project");

		log.debug("projectId: {}", projectId);

		Project selectedProject = projectDao.getProject(projectId);
		modelAndView.addObject("selectedProject", selectedProject);
		log.debug("selectedProject: {}", selectedProject);

		List<Question> questions = questionDao.getQuestions(projectId);
		modelAndView.addObject("questions", questions);
		log.debug("Questions: {}", questions);

		return modelAndView;
	}

	@RequestMapping("/payments")
	public ModelAndView payments(@RequestParam(name = "projectId") int projectId) {
		ModelAndView modelAndView = new ModelAndView("payments");

		modelAndView.addObject("projectId", projectId);
		log.debug("projectId: {}", projectId);

		List<Reward> rewards = rewardDao.getRewards(projectId);
		modelAndView.addObject("rewards", rewards);
		log.debug("Rewards: {}", rewards);

		return modelAndView;
	}

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public ModelAndView questionGet(@RequestParam(name = "projectId") int projectId) {
		ModelAndView modelAndView = new ModelAndView("question");

		modelAndView.addObject("projectId", projectId);
		log.debug("projectId: {}", projectId);

		return modelAndView;
	}
	
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public ModelAndView questionPost(@RequestParam(name = "projectId") int projectId,
			@RequestParam(name = "questionText") String questionText) {
		ModelAndView modelAndView = new ModelAndView("redirect:project.html");

		modelAndView.addObject("projectId", projectId);
		log.debug("projectId: {}", projectId);
		log.debug("questionText: {}", questionText);
		
		Question question = new Question();
		question.setProjectId(projectId);
		question.setQuestionText(questionText);
		questionDao.addQuestion(question);
		log.info("new Question {}", question);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/pledge", method = RequestMethod.GET)
	public ModelAndView pledgeGet(@RequestParam(name = "projectId") int projectId,
			@RequestParam(name = "rewardId") int rewardId,
			@RequestParam(name = "amount") int amount) {
		ModelAndView modelAndView = new ModelAndView("pledge");

		modelAndView.addObject("projectId", projectId);
		log.debug("projectId: {}", projectId);
		
		modelAndView.addObject("rewardId", rewardId);
		log.debug("rewardId: {}", rewardId);
		
		if (rewardId != 0) {
			Reward reward = rewardDao.getReward(rewardId);
			amount = reward.getPledge();
		}
		modelAndView.addObject("amount", amount);
		log.debug("amount: {}", amount);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/pledge", method = RequestMethod.POST)
	public ModelAndView pledgePost(@RequestParam(name = "projectId") int projectId,
			@RequestParam(name = "rewardId") int rewardId,
			@RequestParam(name = "amount") int amount,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "cardNumber") String cardNumber) {
		ModelAndView modelAndView = new ModelAndView("redirect:project.html");

		modelAndView.addObject("projectId", projectId);
		log.debug("projectId: {}", projectId);
		log.debug("rewardId: {}", rewardId);
		log.debug("amount: {}", amount);
		log.debug("name: {}", name);
		log.debug("cardNumber: {}", cardNumber);
		
		Payment payment = new Payment();
		payment.setProject(projectDao.getProject(projectId));
		payment.setName(name);
		payment.setCardNumber(cardNumber);
		payment.setPledge(amount);	
		paymentDao.addPayment(payment);
		log.info("new Payment {}", payment);
		
		return modelAndView;
	}
	
}
