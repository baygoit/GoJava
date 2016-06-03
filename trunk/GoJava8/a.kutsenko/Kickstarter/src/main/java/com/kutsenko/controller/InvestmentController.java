package com.kutsenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kutsenko.dao.ProjectDao;
import com.kutsenko.domain.Investment;
import com.kutsenko.domain.Project;

@Controller
public class InvestmentController {

	@Autowired
	private ProjectDao projectDao;

	private ModelAndView getInvestmentModelAndView(int projectId) {
		ModelAndView modelAndView = new ModelAndView("investment");
		try {
			Project project = projectDao.getWithRewards(projectId);
			modelAndView.addObject(project);
			return modelAndView;
		} catch (EmptyResultDataAccessException e) {

			modelAndView.setViewName("error404");
			modelAndView.addObject("errorText", "error.projectNotFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "/investment/{projectId}", method = RequestMethod.GET)
	public ModelAndView showProject(@PathVariable Integer projectId,
			@ModelAttribute("investment") Investment investment) {
		ModelAndView modelAndView = getInvestmentModelAndView(projectId);
		modelAndView.addObject(new Investment());
		return modelAndView;
	}

	@RequestMapping(value = "/investment/{projectId}", method = RequestMethod.POST)
	public ModelAndView addQuestion(@PathVariable Integer projectId,
			@ModelAttribute("investment") Investment investment, BindingResult errors) {
		    ModelAndView modelAndView = new ModelAndView("redirect:/project/" + projectId);
		try {
			Project project = projectDao.get(projectId);
			investment.setProject(project);
		} catch (EmptyResultDataAccessException e) {

			modelAndView.setViewName("error404");
			modelAndView.addObject("errorText", "error.projectNotFound");
			return modelAndView;
		}
		projectDao.addInvestment(investment);
		return modelAndView;
	}

}
