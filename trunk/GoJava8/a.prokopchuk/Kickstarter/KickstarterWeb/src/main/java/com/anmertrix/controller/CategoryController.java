package com.anmertrix.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.PaymentDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PaymentDao paymentDao;

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public String showCategory(@PathVariable Long id, Map<String, Object> model) {
		if (!categoryDao.isExists(id)) {
			return "404";
		}
		Category category = categoryDao.getCategory(id);
		model.put("category", category);
		model.put("projects", projectDao.getProjects(id));
		return "projects";
	}
	
}
