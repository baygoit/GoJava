package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dto.CategoryDto;
import ua.com.goit.gojava7.kickstarter.service.CategoryService;
import ua.com.goit.gojava7.kickstarter.service.ProjectService;

@Transactional
@Controller
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/index")//all
    public ModelAndView start() {//getAll
        log.info("start()...");

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("quote", quoteDao.getRandomQuote());
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @RequestMapping("/category")
    public ModelAndView showCategory(@RequestParam Long categoryId) {
        log.info("showCategory(categoryId = {})...", categoryId);

        CategoryDto categoryDto = categoryService.get(categoryId);

        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("projects", projectService.getShortProjectsByCategory(categoryId));
       // modelAndView.addObject("projects", categoryDto.getProjects());
        modelAndView.addObject("categoryName", categoryDto.getName());

        return modelAndView;
    }
}




