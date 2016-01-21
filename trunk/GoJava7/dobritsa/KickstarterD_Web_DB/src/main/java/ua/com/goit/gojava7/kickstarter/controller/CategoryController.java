package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dto.CategoryDto;
import ua.com.goit.gojava7.kickstarter.service.CategoryService;
import ua.com.goit.gojava7.kickstarter.service.QuoteService;

@Transactional
@Controller
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/index")
    public ModelAndView showCategories() {
        log.info("showCategories()...");

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("quote", quoteService.getRandomQuote());
        modelAndView.addObject("categories", categoryService.getAll());
        log.info("showCategories() returned {}", modelAndView);

        return modelAndView;
    }

    @RequestMapping("/category")
    public ModelAndView showCategory(@RequestParam Long categoryId) {
        log.info("showCategory(categoryId = {})...", categoryId);

        CategoryDto categoryDto = categoryService.get(categoryId);

        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("categoryName", categoryDto.getName());
        modelAndView.addObject("projects", categoryDto.getProjects());

        log.info("showCategory(categoryId = {}) returned {}", categoryId, modelAndView);
        return modelAndView;
    }
}




