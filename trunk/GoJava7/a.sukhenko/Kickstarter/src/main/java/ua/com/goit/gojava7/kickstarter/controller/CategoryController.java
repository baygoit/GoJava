package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDao;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.validator.QuestionValidator;

@Controller
@Transactional
public class CategoryController{
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryDao         categoryDao;
    @Autowired
    private ProjectDao          projectDao;
    @Autowired
    private QuoteDao            quoteDao;

    public Quote getQuote() {
        return quoteDao.getRandomQuote();
    }

    @RequestMapping(value = "/")
    public String root() {
        return "index";
    }
    @RequestMapping("categories")
    public ModelAndView categories() {
        logger.debug("WebController: categories");
        ModelAndView modelAndView = new ModelAndView("categories");
        List<Category> categories = categoryDao.getAll();
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("quote", quoteDao.getRandomQuote());
        return modelAndView;
    }

    @RequestMapping("category")
    public ModelAndView category(@RequestParam(name = "id") Integer categoryId) {
        logger.debug("action: category");
        ModelAndView modelAndView = new ModelAndView("projects");

        if (categoryId == null || categoryDao.getCategoryById(categoryId) == null) {
            return new ModelAndView("redirect:/categories");
        }

        List<Project> projects = projectDao.getProjectsByCategoryId(categoryId);

        if (projects == null || projects.isEmpty()) {
            modelAndView.addObject("noProjectsFound", true);
        } else {
            modelAndView.addObject("projects", projects);
            modelAndView.addObject("categoryName", categoryDao.getCategoryById(categoryId).getCategoryName());
        }
        return modelAndView;
    }

}
