package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.database.contract.CategoryDao;


@Controller
public class ContactController {
	private static final Logger log = LoggerFactory.getLogger(ContactController.class);
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public ModelAndView showContacts() {
		ModelAndView modelAndView = new ModelAndView("contacts");

		List<Category> categories = categoryDao.getAll();
		log.info("All categories: {}", categories);

		modelAndView.addObject("categories", categories);
		return modelAndView;
	}

}
