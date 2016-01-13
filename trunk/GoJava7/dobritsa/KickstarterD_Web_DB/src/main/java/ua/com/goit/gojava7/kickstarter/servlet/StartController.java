package ua.com.goit.gojava7.kickstarter.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;

@Controller
public class StartController{

    private static final Logger log = LoggerFactory.getLogger(StartController.class);

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;

    @RequestMapping({"/categories", "/", "kickstarter"})
    public ModelAndView start() {
        log.info("start()...");
        ModelAndView modelAndView = new ModelAndView("kickstarter");
        modelAndView.addObject("quote", quoteDao.getRandomQuote());
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping("/category")
    @Transactional
    public ModelAndView showCategory(@RequestParam(name = "id") Long categoryId) {
        log.info("showCategory()...");
        ModelAndView modelAndView = new ModelAndView("category");
        Category category = categoryDao.get(categoryId);

        // TODO
        if (category == null) {
            //404
        }

        modelAndView.addObject("projects", projectDao.getByCategory(categoryId));
        modelAndView.addObject("categoryName", category.getName());
        return modelAndView;
    }

    @RequestMapping("/project")
    @Transactional
    public ModelAndView showProject(@RequestParam(name = "id") Long projectId) {
        log.info("showProject()...");
        ModelAndView modelAndView = new ModelAndView("project");
        Project project = projectDao.get(projectId);


        modelAndView.addObject("category", projectDao.getCategory(project));
        modelAndView.addObject("project", project);
        modelAndView.addObject("questions", projectDao.getQuestions(projectId));
        return modelAndView;
    }



}
