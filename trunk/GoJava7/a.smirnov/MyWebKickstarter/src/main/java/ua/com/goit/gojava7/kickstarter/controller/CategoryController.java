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
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@Controller
public class CategoryController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PaymentDao paymentDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
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

	@RequestMapping(value = "/category", method = RequestMethod.GET)
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
