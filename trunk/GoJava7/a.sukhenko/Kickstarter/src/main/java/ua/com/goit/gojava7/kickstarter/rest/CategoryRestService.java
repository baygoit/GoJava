package ua.com.goit.gojava7.kickstarter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDao;
import ua.com.goit.gojava7.kickstarter.model.Category;

@RestController
@RequestMapping("/rest")
public class CategoryRestService{

    @Autowired
    private CategoryDao categoryDao;
    @RequestMapping("/category/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Integer categoryId){
        return categoryDao.getCategoryById(categoryId);
    }
    
    
}
