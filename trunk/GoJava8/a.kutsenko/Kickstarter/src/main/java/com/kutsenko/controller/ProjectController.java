package com.kutsenko.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.kutsenko.dao.ProjectDao;
import com.kutsenko.domain.Project;
import com.kutsenko.domain.Question;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectDao projectDao;
	

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ModelAndView showProject(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("project");
        try {
            Project project = projectDao.get(id);
            mav.addObject("project", project);
            return mav;
        } catch (EmptyResultDataAccessException e) {
            mav.setViewName("error404");
            mav.addObject("errorText");
            return mav;
        }
    }

    @RequestMapping(value = "/project/{id}/addQuestion", method = RequestMethod.POST)
    public ModelAndView addQuestion(@PathVariable("id") Integer projectId, @RequestParam("question_request") String questionRequest) {
        ModelAndView mav = new ModelAndView("redirect:/project/" + projectId);
        Project project = projectDao.get(projectId);
        Question question = new Question();
        question.setProject(project);
        if (questionRequest.trim().length() == 0) {
            mav.setViewName("error400");
            mav.addObject("errorText");
            return mav;
        }
        question.setRequest(questionRequest);
        projectDao.addQuestion(question);
        return mav;
    }
	

}
