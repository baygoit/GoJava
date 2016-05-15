package ua.dborisenko.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Controller
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ModelAndView showProject(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("project");
        try {
            Project project = projectDao.getWithQuestions(id);
            mav.addObject("project", project);
            return mav;
        } catch (EmptyResultDataAccessException e) {
            mav.setViewName("error404");
            mav.addObject("errorText", ErrorText.PROJECT_NOT_FOUND);
            return mav;
        }
    }

    @RequestMapping(value = "/project/{id}/addQuestion", method = RequestMethod.POST)
    public ModelAndView addQuestion(@PathVariable("id") Integer projectId, @RequestParam String question_request) {
        ModelAndView mav = new ModelAndView("redirect:/project/" + projectId);
        Project project = projectDao.get(projectId);
        Question question = new Question();
        question.setProject(project);
        if (question_request.trim().length() == 0) {
            mav.setViewName("error400");
            mav.addObject("errorText", ErrorText.EMPTY_STRING);
            return mav;
        }
        question.setRequest(question_request);
        projectDao.addQuestion(question);
        // RedirectView redirect = new RedirectView("error500");
        // redirect.setExposeModelAttributes(false);
        // mav.setView(redirect);
        return mav;
    }
}
