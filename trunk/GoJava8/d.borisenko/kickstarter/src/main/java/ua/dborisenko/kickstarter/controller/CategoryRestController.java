package ua.dborisenko.kickstarter.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.RestResult;
import ua.dborisenko.kickstarter.dto.CategoryDto;

@RestController
@RequestMapping(value = "/rest/category")
public class CategoryRestController {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private Mapper dtoMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestResult returnCategory(@PathVariable Integer id) {
        RestResult result = new RestResult();
        Category category;
        try {
            category = categoryDao.get(id);
        } catch (EmptyResultDataAccessException e) {
            result.setStatus("ERROR");
            result.setCode(404);
            result.addToData("Description", "The requested category isn`t found.");
            return result;
        }
        result.addToData("category", dtoMapper.map(category, CategoryDto.class, "categorySimple"));
        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RestResult addCategory(@RequestParam(value = "name", required = true) String name) {
        RestResult result = new RestResult();
        int id;
        try {
            id = categoryDao.add(name);
        } catch (Exception e) {
            result.setStatus("ERROR");
            result.setCode(500);
            result.addToData("Description", "Could not add the category.");
            return result;
        }
        result.addToData("category", dtoMapper.map(categoryDao.get(id), CategoryDto.class, "categorySimple"));
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public RestResult updateCategory(@PathVariable Integer id,
            @RequestParam(value = "name", required = true) String name) {
        RestResult result = new RestResult();
        Category category;
        try {
            category = categoryDao.get(id);
            category.setName(name);
            categoryDao.update(category);
        } catch (EmptyResultDataAccessException e) {
            result.setStatus("ERROR");
            result.setCode(404);
            result.addToData("Description", "The requested category isn`t found.");
            return result;
        } catch (Exception e) {
            result.setStatus("ERROR");
            result.setCode(500);
            result.addToData("Description", "Could not add the category.");
            return result;
        }
        result.addToData("category", dtoMapper.map(category, CategoryDto.class, "categorySimple"));
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult deleteCategory(@PathVariable Integer id) {
        RestResult result = new RestResult();
        try {
            categoryDao.delete(id);
        } catch (Exception e) {
            result.setStatus("ERROR");
            result.setCode(500);
            result.addToData("Description", "Could not delete the category.");
            return result;
        }
        return result;
    }
}
