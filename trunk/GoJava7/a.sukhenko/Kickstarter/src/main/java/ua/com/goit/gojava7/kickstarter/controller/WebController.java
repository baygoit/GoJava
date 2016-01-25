package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuestionDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDatabaseDao;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.validator.QuestionValidator;

@Controller
@Transactional
public class WebController{
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    @Autowired
    private CategoryDatabaseDao categoryDao;
    @Autowired
    private ProjectDao  projectDao;
    @Autowired
    private QuoteDatabaseDao    quoteDao;
    @Autowired
    private QuestionDatabaseDao questionDao;
    @Autowired
    private QuestionValidator validator;
    
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

    

    
    @RequestMapping("reward")
    public ModelAndView reward(@RequestParam int projectId){
        ModelAndView modelAndView = new ModelAndView("reward");
        Project project = projectDao.getProject(projectId);
        modelAndView.addObject("paymentBonuses", project.getBonuses());
        modelAndView.addObject(project);
        modelAndView.addObject(project.getCategory());
        return modelAndView;
        
    }
    
    
    

}
