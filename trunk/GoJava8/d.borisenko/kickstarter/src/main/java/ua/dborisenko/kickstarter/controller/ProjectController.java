package ua.dborisenko.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Controller
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;
    
    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ModelAndView showProject(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("project");
        try {
            Project project = projectDao.getWithQuestions(id);
            modelAndView.addObject(project);
            Question question = new Question();
            modelAndView.addObject(question);
            return modelAndView;
        } catch (EmptyResultDataAccessException e) {
            log.warn("Could not found project with id {}", id);
            modelAndView.setViewName("error404");
            modelAndView.addObject("errorText", "error.projectNotFound");
            return modelAndView;
        }
    }
}
