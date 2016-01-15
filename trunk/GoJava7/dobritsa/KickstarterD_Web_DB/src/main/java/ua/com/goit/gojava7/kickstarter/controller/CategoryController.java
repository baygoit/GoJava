package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.models.Category;

@Transactional
@Controller
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping({"/*", "/index"})
    public ModelAndView start() {
        log.info("start()...");

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("quote", quoteDao.getRandomQuote());
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView showCategory(@RequestParam Long categoryId) {
        log.info("showCategory()...");

        Category category = categoryDao.get(categoryId);

        // TODO
        if (category == null) {
            //404
        }

        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("projects", categoryDao.getProjects(categoryId));
        modelAndView.addObject("categoryName", category.getName());
        return modelAndView;
    }
}




