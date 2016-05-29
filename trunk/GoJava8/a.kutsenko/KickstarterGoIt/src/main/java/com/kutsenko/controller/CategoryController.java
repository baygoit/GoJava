package com.kutsenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kutsenko.dao.CategoryDao;
import com.kutsenko.domain.Category;

@Controller
public class CategoryController {

	
	@Autowired
	private CategoryDao categoryDao;//miro


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showCategories() {
		 ModelAndView maw = new ModelAndView("categories");
	        maw.addObject("categories", categoryDao.getAll());
	        return maw;
	}

	@RequestMapping (value = "/category/{id}" , method = RequestMethod.GET)
	public ModelAndView showCategory(@PathVariable Integer id ){
		ModelAndView mav = new ModelAndView("category");
		try {
			Category category = categoryDao.getById(id);
			mav.addObject("category", category);
            return mav;
		} catch (Exception e) {
			mav.setViewName("eror404");
			return mav;
		}
	}

}
