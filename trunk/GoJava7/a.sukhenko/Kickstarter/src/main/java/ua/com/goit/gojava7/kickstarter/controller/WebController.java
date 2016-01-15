package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuestionDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.error.ResourceNotFoundException;
import ua.com.goit.gojava7.kickstarter.util.Validator;

@Controller
@Transactional
public class WebController{
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    @Autowired
    private CategoryDatabaseDao categoryDao;
    @Autowired
    private ProjectDatabaseDao  projectDao;
    @Autowired
    private QuoteDatabaseDao    quoteDao;
    @Autowired
    private QuestionDatabaseDao questionDao;
    @Autowired
    private Validator validator;
    
    
    public Quote getQuote(){
        return quoteDao.getRandomQuote();
    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }
    
    
    @RequestMapping("categories")
    public ModelAndView categories() {
        ModelAndView modelAndView = new ModelAndView("categories");
        logger.debug("WebController: categories");
        List<Category> categories = categoryDao.getAll();
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("quote", quoteDao.getRandomQuote());
        return modelAndView;
    }

    @RequestMapping("category")
    public ModelAndView category(@RequestParam(name = "id") int categoryId) {
        ModelAndView modelAndView = new ModelAndView("projects");
        logger.debug("action: category");
        List<Project> projects = projectDao.getProjectsByCategoryId(categoryId);
        modelAndView.addObject("projects", projects);
        modelAndView.addObject("categoryName", categoryDao.getCategoryById(categoryId).getCategoryName());
        return modelAndView;
    }

    @RequestMapping("project")
    public ModelAndView project(@RequestParam(name = "name") String projectName) {
        ModelAndView modelAndView = new ModelAndView("project");
        logger.debug("action: project");
        Project project = null;
        try {
            project = projectDao.getProjectByName(projectName);
        } catch (NoSuchElementException e) {
            logger.info("Didn't find project", e);
            throw new ResourceNotFoundException();
        }
        modelAndView.addObject("project", project);
        modelAndView.addObject("endtime", project.getProjectEndTime());
        modelAndView.addObject("paymentBonuses", project.getBonuses());
        List<Question> questions = questionDao.getQuestionsByProjectId(project.getId());
        modelAndView.addObject("questions", questions);
        return modelAndView;
    }
    
    


}
