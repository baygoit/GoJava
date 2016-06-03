package com.kutsenko.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.kutsenko.dao.CategoryDao;
import com.kutsenko.domain.Category;

@RestController
@RequestMapping("/rest")
public class CategoryRest {
	
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value ="/category/{Id}" , method = RequestMethod.GET)
	public Category showCategories(@PathVariable("Id") Integer Id) {
		Category category = categoryDao.getById(Id);
		return category;
	}

}
