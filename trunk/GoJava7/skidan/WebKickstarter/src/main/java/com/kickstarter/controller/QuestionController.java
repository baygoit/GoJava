package com.kickstarter.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.kickstarter.beanVO.QuestionVo;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import static com.kickstarter.util.Constants.*;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionDaoImpl questionDao;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addQuestion(@Valid @ModelAttribute("questionVo") QuestionVo questionVO, BindingResult result,
			@RequestParam Map<String, String> requestParams) {
		if (result.hasErrors()) {
			return new ModelAndView("questionForm").addObject(PROJECT_ID_KEY, requestParams.get(PROJECT_ID_KEY));
		}
		int projectId = Integer.parseInt(requestParams.get(PROJECT_ID_KEY));
		questionDao.add(requestParams.get("question"), projectId);
		return new ModelAndView("redirect:/project?projectId=" + projectId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView acceptQuestion(@ModelAttribute("questionVo") QuestionVo questionVo,
			@RequestParam Map<String, String> requestParams) {
		ModelAndView modelAndView = new ModelAndView("questionForm");
		modelAndView.addAllObjects(requestParams);
		return modelAndView;

	}

}
