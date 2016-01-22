package com.kickstarter.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kickstarter.beanVO.QuestionVO;
import com.kickstarter.dao.Impl.ProjectDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import com.kickstarter.model.Project;

@Controller
@Transactional
@RequestMapping("/question")
public class QuestionController {
	
	private final String PROJECT_ID = "projectId";


	@Autowired
	QuestionDaoImpl questionDao;
	@Autowired
	ProjectDaoImpl projectDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		binder.setDisallowedFields("project");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addQuestion(@Valid @ModelAttribute("questionVO") QuestionVO questionVO, BindingResult result,
			@RequestParam Map<String, String> requestParams) {
		if (result.hasErrors()) {
			return new ModelAndView("QuestionInputForm").addObject(PROJECT_ID, requestParams.get(PROJECT_ID));
		} else {

			int projectId = Integer.parseInt(requestParams.get(PROJECT_ID));
			String question = requestParams.get("question");
			Project project = projectDao.getOneProject(projectId);
			questionDao.add(question, project);
			return new ModelAndView("redirect:/project?projectId=" + projectId);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView acceptQuestion(@ModelAttribute("questionVO") QuestionVO questionVo,
			@RequestParam Map<String, String> requestParams) {
		ModelAndView modelAndView = new ModelAndView("QuestionInputForm");
		modelAndView.addAllObjects(requestParams);
		return modelAndView;

	}

}
