package com.anmertrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

@Controller
public class QuestionController {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@RequestMapping(value = "/project/{projectId}/addQuestion", method = RequestMethod.POST)
	public ModelAndView addQuestion(@PathVariable Integer projectId, @RequestParam("question") String questionText) {
        ModelAndView modelAndView = new ModelAndView("redirect:/project/" + projectId);
        Project project = projectDao.getProject(projectId);
        Question question = new Question();
        question.setProject(project);
        if (!validateQuestion(questionText)) {
            modelAndView.setViewName("404");
            return modelAndView;
        }
        question.setQuestion(questionText.trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"));
        questionDao.insertQuestion(question);
        return modelAndView;
    }
	
	private boolean validateQuestion(String questionText) {
		String question = questionText.trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		return !(question.length() < 2 || question.length() > 500);
	}
	
}
